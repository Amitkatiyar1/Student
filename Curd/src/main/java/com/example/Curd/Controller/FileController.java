package com.example.Curd.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.Curd.Model.FileModelClass;
import com.example.Curd.Model.ResponseFile;
import com.example.Curd.Model.User;
import com.example.Curd.Service.FileService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@RestController
@CrossOrigin("*")
public class FileController {

	private static final String DIR = "C:\\Users\\AmitKatiyar";
	@Autowired
	private FileService storageService;
	
	@Autowired
	private ObjectMapper mapper;
	
	Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@PostMapping("/JSon")
	public ResponseEntity<?> addUserInformation(@RequestParam("file") MultipartFile file,@RequestParam("userData") String userData ){
		
		this.logger.info("add User Request");
		logger.info("File information {}",file.getOriginalFilename());
		// Converting String into Json
		User user=null;
		try {
			 user = mapper.readValue(userData,User.class);
		} catch (JsonProcessingException e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Request");
		}
		
		this.logger.info("User data is :{}",user);
		return ResponseEntity.ok(user);
	}
	
	
	// Save the file local Storage and db
	@PostMapping("/addFile")
	public ResponseEntity<?> addFile(@RequestParam("file") MultipartFile file, FileModelClass data) throws IOException {

		String filename = "";


		filename = StringUtils.cleanPath(file.getOriginalFilename()) + Integer.toString(new Random().nextInt(100));
		System.out.println(filename);
		java.nio.file.Path fileStorage = Paths.get(DIR, filename).toAbsolutePath().normalize();
		Files.copy(file.getInputStream(), fileStorage, StandardCopyOption.REPLACE_EXISTING);

		data.setFileName(file.getOriginalFilename());
		data.setFileType(file.getContentType());
		data.setFilePath(fileStorage.toString());
		data.setData(file.getBytes());
		storageService.saveFile(data);

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PostMapping("/upload")
	public ResponseEntity<?> uploadFiles(@RequestParam("files") MultipartFile[] files) {

		List<String> fileNames = new ArrayList<>();

		Arrays.asList(files).stream().forEach(file -> {
			storageService.save(file);
			fileNames.add(file.getOriginalFilename());
		});
		return null;

	}
	
     // get all fileList 

	@GetMapping("/getFile")
	public ResponseEntity<List<ResponseFile>> getListFiles() {

		List<ResponseFile> files = storageService.getFile().map(dbFile -> {

			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/download/")
					.path(dbFile.getId())

					.toUriString();

			return new ResponseFile(

					dbFile.getFileName(),

					fileDownloadUri,

					dbFile.getFileType());

		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(files);

	}

	// download file using fileId

	@GetMapping("download/{fileId}")
	public ResponseEntity<?> downloadFile(@PathVariable String fileId) throws FileNotFoundException {
		Resource resource = storageService.loadFile(fileId);

		return ResponseEntity.ok()
				.header("Content-Disposition", "attachment;  filename=\"" + resource.getFilename() + " \"")
				.body(resource);
	};

	@GetMapping("/getAll")
	public ResponseEntity<?> getFile() {

		List<FileModelClass> myFileDatas = storageService.getAllFiles();

		return new ResponseEntity<>(myFileDatas, myFileDatas.size() > 0 ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("del/{fileName}")
	public ResponseEntity<?> deleteById(@PathVariable("fileName") String fileName) {

		storageService.deleteOne(fileName);

		return null;

	}
}
