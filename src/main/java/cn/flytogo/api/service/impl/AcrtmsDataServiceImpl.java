package cn.flytogo.api.service.impl;

import cn.flytogo.api.pojo.entity.AcrtmsData;
import cn.flytogo.api.service.AcrtmsDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;

/**
 * @Description
 * @Author wyb
 * @Date 2023/12/9 14:22
 **/

@Service
public class AcrtmsDataServiceImpl implements AcrtmsDataService {

    @Value("${constant.path}")
    private String path;

    @Value("${constant.fileName}")
    private String fileName;

    @Override
    public void increase(String data, String id) {
        AcrtmsData acrtmsData = AcrtmsData.parse(data);
        acrtmsData.setId(id);

        writeToFile(acrtmsData.toString(), path + fileName);
    }

    @Override
    public void clear() {
        try {
            Files.write(Paths.get(path + fileName), Collections.emptyList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(String dataString, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(dataString);
            writer.newLine(); // 换行
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
