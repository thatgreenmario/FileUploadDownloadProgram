package com.app.core.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.core.exception.StorageException;
import com.app.core.services.StorageService;

@Controller
public class uploadController {

    @Autowired
    private StorageService storageService;

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST,consumes = {"multipart/form-data"})
    public boolean upload(@RequestParam MultipartFile file) {

        storageService.uploadFile(file);

        return true;
    }

    @ExceptionHandler(StorageException.class)
    public boolean handleStorageFileNotFound(StorageException e) {

        return false;
    }
}