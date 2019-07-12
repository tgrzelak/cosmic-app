package tgrzelak.commons.storage;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class LocalFileController {

    private LocalFileService localFileService;

    public LocalFileController(LocalFileService localFileService) {
        this.localFileService = localFileService;
    }

    @GetMapping("/files")
    public List<LocalFile> getResources() throws IOException {
        return localFileService.getResources();
    }

    @PostMapping("/files")
    public void uploadFile(@RequestParam MultipartFile file) throws IOException {
        localFileService.uploadFile(file);
    }

    @GetMapping("/files/download/{filename}")
    public ResponseEntity<?> downloadFile(@PathVariable String filename) throws IOException {
        File file = localFileService.downloadFile(filename);
        Path path = Paths.get(localFileService.getUploads() + filename);
        Resource resource = new UrlResource(path.toUri());

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(Files.probeContentType(file.toPath())))
                    .header(HttpHeaders.CONTENT_DISPOSITION,
                            "attachment; filename= \"" + file.getName() + "\"")
                    .contentLength(file.length())
                    .body(resource);

    }

    @DeleteMapping("/files/delete/{filename}")
    public void deleteFile(@PathVariable String filename) {
        localFileService.deleteFile(filename);
    }


}
