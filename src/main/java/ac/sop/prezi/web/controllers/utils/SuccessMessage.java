package ac.sop.prezi.web.controllers.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonRootName;
import java.time.LocalDateTime;

@JsonRootName(value = "success")
public class SuccessMessage {

    private String text;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;

    private SuccessMessage() {
        this.timestamp = LocalDateTime.now();
    }

    public SuccessMessage(String text) {
        this();
        this.text = text;
    }

    public String getText() {
        return text;

    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}

