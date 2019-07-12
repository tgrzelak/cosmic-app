package tgrzelak.commons.storage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LocalFile {

    private String name;
    private String creationTime;
    private String lastModified;
    private Long size;
    private String downloadUri;
    private String deleteUri;
    private String fileType;
}
