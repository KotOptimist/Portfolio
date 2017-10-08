package ru.zolotarev.portfolio.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminPageController {

	@Autowired
	private ServletContext servletContext;

	/**
	 * POST /uploadFile -> receive and locally save a file.
	 *
	 * @param uploadfile The uploaded file as Multipart file parameter in the
	 * HTTP request. The RequestParam name must be the same of the attribute
	 * "name" in the input tag with type file.
	 *
	 * @return An http OK status in case of success, an http 4xx status in case
	 * of errors.
	 */
	@PostMapping(value = "/uploadFile")
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ResponseEntity<?> uploadFile(@RequestParam("uploadfile") MultipartFile uploadfile) {

		try {
			// Get the filename and build the local file path (be sure that the
			// application have write permissions on such directory)
			String filename = uploadfile.getOriginalFilename();
			String directory = servletContext.getRealPath("/resources/files");
			String filepath = Paths.get(directory, filename).toString();
			// Save the file locally
			BufferedOutputStream stream =
					new BufferedOutputStream(new FileOutputStream(new File(filepath)));
			stream.write(uploadfile.getBytes());
			stream.close();
		}
		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	} // method uploadFile
}
