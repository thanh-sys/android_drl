package hcm.ptit.trainingpoint.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import hcm.ptit.trainingpoint.enitty.DBFile;
import hcm.ptit.trainingpoint.exception.FileStorageException;
import hcm.ptit.trainingpoint.exception.MyFileNotFoundException;
import hcm.ptit.trainingpoint.repository.DBFileRepository;

import java.io.IOException;

@Service
public class DBFileStorageService {

    private DBFileRepository dbFileRepository;

    @Autowired
    public void setDbFileRepository(DBFileRepository dbFileRepository) {
        this.dbFileRepository = dbFileRepository;
    }

    public DBFile storeFile(MultipartFile file) throws FileStorageException {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            DBFile dbFile = new DBFile(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!");
        }
    }

    public DBFile getFile(String fileId) throws MyFileNotFoundException {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}
