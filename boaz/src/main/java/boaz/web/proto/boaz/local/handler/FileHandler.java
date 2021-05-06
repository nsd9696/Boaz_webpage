package boaz.web.proto.boaz.local.handler;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Component
public class FileHandler {
    // local 기준
    // 파일 저장하는 함수
    // 1. 이미지가 존재하지 않은 경우 -> 이미지를 저장하고 경로를 보내주면 됨
    // 2. 이미지가 존재할 경우 -> 이미지 경로를 보내주면 됨
    // return 이미지 파일이 저장된 주소를 반환

    @Autowired
    ResourceLoader resourceLoader;

    private static final String REPOSITORY_PATH = "resources/static/images/";

    // 특정 폴더에 파일 저장
    public String saveImage(String folder,MultipartFile file) {
        File uploadPath = new File(REPOSITORY_PATH, folder+"/"+file.getOriginalFilename());

        // 해당 폴더 없으면 폴더 생성
        if (!uploadPath.exists()) {
            uploadPath.mkdirs();
        }

        try {
            Path path = Paths.get(uploadPath + "/" + file.getOriginalFilename());
            File f = new File(REPOSITORY_PATH + "/" + folder + "/" + file.getOriginalFilename());

            // 이미지 있으면 바로 리턴
            if(f.exists())
                return REPOSITORY_PATH + "/" + folder + "/" + file.getOriginalFilename();

            // 이미지 없으면 파일 저장
            Files.write(path, file.getBytes());
        } catch (IOException e) {
            return "IOException";
        }
        
        return REPOSITORY_PATH + "/" + folder + "/" + file.getOriginalFilename();
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

    public String saveImage2(HttpServletRequest request, MultipartFile file){
        UUID uuid = UUID.randomUUID();
        String saveName = uuid + "_" + file.getOriginalFilename();
        // 저장할 File 객체를 생성(껍데기 파일)ㄴ
        String path = System.getProperty("user.dir" + REPOSITORY_PATH);
        File saveFile = new File(REPOSITORY_PATH+saveName); // 저장할 폴더 이름, 저장할 파일 이름
        try {
            FileCopyUtils.copy(file.getBytes(), saveFile);
             // 업로드 파일에 saveFile이라는 껍데기 입힘
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return saveName;    
    }




    //server기준으로는 그냥 저장하고 경로 보내주기
    // s3에 저장하면
    // 파일이 해당서버에 존재하는지 확인
}
