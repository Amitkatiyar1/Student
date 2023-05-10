package com.example.Curd.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.apache.tomcat.util.http.fileupload.FileItemIterator;
import org.apache.tomcat.util.http.fileupload.FileItemStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.Curd.Exception.EmployeeException;
import com.example.Curd.Model.Employee;
import com.example.Curd.Model.FileModelClass;
import com.example.Curd.Repository.StorageRepositiory;


@Service
public class FileService {

	@Autowired
	StorageRepositiory repo;
	
	private final Path root = Paths.get("C:\\Users\\AmitKatiyar");
	
	
	public FileModelClass saveFile(FileModelClass file) throws IOException {

		return repo.save(file);
	}

	public void save(MultipartFile file) {
		try {
			Files.copy(file.getInputStream(), this.root.resolve(file.getOriginalFilename()));
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
	}

	public void upload(FileItemIterator iter) throws IOException {
		while (iter.hasNext()) {
			FileItemStream item = iter.next();
			if (item.isFormField()) {
				continue;
			}
			upload((FileItemIterator) item);
		}
	}

	public Stream<FileModelClass> getFile() {

		return repo.findAll().stream();
	}

	public Resource loadFile(String fileId) throws FileNotFoundException {

		Optional<FileModelClass> optionalFile = repo.findById(fileId);

		if (!optionalFile.isPresent()) {

			throw new FileNotFoundException("File not found with ID: " + fileId);
		}

		FileModelClass file = optionalFile.get();

		Path filePath = Paths.get(file.getFilePath());

		Resource resource = new FileSystemResource(filePath.toFile());

		if (!resource.exists() || !resource.isReadable()) {

			throw new FileNotFoundException("File not found: " + file.getFileName());
		}

		return resource;
	}

	public List<FileModelClass> getAllFiles() {
		List<FileModelClass> file = repo.findAll();
		if (file.size() > 0) {
			return file;
		}
		return new ArrayList<FileModelClass>();

	}

	public boolean deleteOne(String fileName) {

		try {
			Path file = root.resolve(fileName);

			return Files.deleteIfExists(file);
		} catch (IOException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}

	}

	
	

}
