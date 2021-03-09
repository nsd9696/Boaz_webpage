package boaz.web.proto.boaz.local.handler;


import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandler {
    // local 기준
    // 파일 저장하는 함수
    // 1. 이미지가 존재하지 않은 경우 -> 이미지를 저장하고 경로를 보내주면 됨
    // 2. 이미지가 존재할 경우 -> 이미지 경로를 보내주면 됨
    // return 이미지 파일이 저장된 주소를 반환


    private static final String REPOSITORY_PATH = "Users/KimMinyoung/Documents/Github/Boaz_webpage/src/main/resources/static/images/";

    // 특정 폴더에 파일 저장
    public static String saveImage(String folder, String filename, byte[] imgBytes) {
        File uploadPath = new File(REPOSITORY_PATH, folder);

        // 해당 폴더 없으면 폴더 생성
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }

        try {
            Path path = Paths.get(uploadPath + "/" + filename);
            File f = new File(REPOSITORY_PATH + "/" + folder + "/" + filename);

            // 이미지 있으면 바로 리턴
            if(f.exists())
                return REPOSITORY_PATH + "/" + folder + "/" + filename;

            // 이미지 없으면 파일 저장
            Files.write(path, imgBytes);
        } catch (IOException e) {
            return "IOException";
        }

        return REPOSITORY_PATH + "/" + folder + "/" + filename;
    }

    // 파일 로드
    public static void loadImage(String middlePath, String imageFileName, HttpServletResponse response) throws IOException {
        OutputStream out = response.getOutputStream();
        String path = REPOSITORY_PATH + middlePath + "/" + imageFileName;
        File imageFile = new File(path);
        FileInputStream in = new FileInputStream(imageFile);

        response.setHeader("Cache-Control", "no-cache");
        response.addHeader("Content-disposition", "attachment;fileName="+imageFileName);

        byte[] buffer = new byte[1024 * 8];
        while(true) {
            int count = in.read(buffer);
            if(count == -1)
                break;
            out.write(buffer, 0, count);
        }
        in.close();
        out.close();
    }




    //server기준으로는 그냥 저장하고 경로 보내주기
    // s3에 저장하면
    // 파일이 해당서버에 존재하는지 확인
}
