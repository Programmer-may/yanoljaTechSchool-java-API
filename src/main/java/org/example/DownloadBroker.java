package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import java.io.FileOutputStream;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DownloadBroker extends Thread{
    // extends Thread 대신에 implements Runnable 도 가능
    //스레드가 처리하는 작업 클래스

    private String imageUrl;
    private String imageName;
    private HttpClient httpClient;
    public void run(){
        try {
            HttpGet httpGet = new HttpGet(imageUrl); // get방식 (연결)
            HttpResponse response = httpClient.execute(httpGet); //실행 (요청 후 응답)
            HttpEntity entity = response.getEntity();
            FileOutputStream fos = new FileOutputStream(imageName);

            //버퍼에 저장한 후에 다운로드 하는게 좋다
            byte[] ingBuf = EntityUtils.toByteArray(entity);
            fos.write(ingBuf);
            fos.close();

            System.out.println("이미지 다운로드 완료");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
