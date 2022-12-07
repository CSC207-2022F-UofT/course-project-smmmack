package file_test;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.File;

public class FileTests {
    @Test
    public void FileRelativePath() {
        File picture = new File("gfx/default_board.png");
        Assertions.assertTrue(picture.isFile());
    }
}
