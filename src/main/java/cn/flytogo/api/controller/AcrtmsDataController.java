package cn.flytogo.api.controller;

import cn.flytogo.api.common.Result;
import cn.flytogo.api.service.AcrtmsDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 24294
 */

@RestController
@RequestMapping("/acrtms")
@Slf4j
public class AcrtmsDataController {

    @Resource
    private AcrtmsDataService acrtmsDataService;

    @Value("${constant.path}")
    private String path;

    @Value("${constant.fileName}")
    private String fileName;

    @PostMapping("/data")
    public Result<Void> receiveData(@RequestParam("code") String code,
                                    @RequestParam("from") String from) {
        acrtmsDataService.increase(code, from);
        return new Result<>();
    }

    @GetMapping("/data")
    @ResponseBody
    public String getData() {
        try {
            // 读取文件内容
            Path filePath = Paths.get(path + fileName);
            byte[] bytes = Files.readAllBytes(filePath);
            String txtContent = new String(bytes);

            return "<pre>" + txtContent + "</pre>";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/data/clear")
    public Result<String> clearData(HttpServletResponse response) throws IOException{
        acrtmsDataService.clear();
        response.sendRedirect("/acrtms/data");
        return Result.success("清除成功");
    }
}
