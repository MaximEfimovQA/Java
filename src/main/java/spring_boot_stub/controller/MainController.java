package spring_boot_stub.controller;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.io.ClassPathResource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import jakarta.annotation.PostConstruct;
import spring_boot_stub.dto.PostRequest;

@RestController
@RequestMapping("/app/v1")
public class MainController {
    private String getAnswerTemplate;
    private String postAnswerTemplate;

    @PostConstruct
    public void initTemplates() throws IOException {
        // Чтение первого файла
        ClassPathResource getAnswerResource = new ClassPathResource("static/getAnswer.txt");
        try (BufferedReader getAnswerReader = new BufferedReader(
                new InputStreamReader(getAnswerResource.getInputStream(), StandardCharsets.UTF_8))) {
            this.getAnswerTemplate = getAnswerReader.lines().collect(Collectors.joining("\n"));
        }

        // Чтение второго файла
        ClassPathResource postAnswerResource = new ClassPathResource("static/postAnswer.txt");
        try (BufferedReader postAnswerReader = new BufferedReader(
                new InputStreamReader(postAnswerResource.getInputStream(), StandardCharsets.UTF_8))) {
            this.postAnswerTemplate = postAnswerReader.lines().collect(Collectors.joining("\n"));
        }
    }

    @GetMapping("/getRequest")
    public ResponseEntity<String> getRequest(
            @RequestParam int id,
            @RequestParam String name) throws InterruptedException {

        if (id <= 10) return error("id должен быть > 10");
        if (name.length() <= 5) return error("Длина name должна быть > 5");

        TimeUnit.MILLISECONDS.sleep((id > 10 && id < 50) ? 1000 : 500);

        return ResponseEntity.ok(
                getAnswerTemplate
                        .replace("{id}", String.valueOf(id))
                        .replace("{name}", name)
        );
    }

    @PostMapping("/postRequest")
    public ResponseEntity<String> postRequest(@RequestBody PostRequest request) {
        if (request.name() == null || request.name().trim().isEmpty() ||
                request.surname() == null || request.surname().trim().isEmpty() ||
                request.age() == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Все поля обязательны");
        }


            String stage1 = postAnswerTemplate
                    .replace("{name}", request.name())
                    .replace("{surname}", request.surname())
                    .replace("{age}", String.valueOf(request.age()));

            String stage2 = evaluateExpressions(stage1);

            return ResponseEntity.ok(stage2);

    }

    private String evaluateExpressions(String template) {
        Pattern pattern = Pattern.compile("(\\d+)\\s*\\*\\s*(\\d+)");
        Matcher matcher = pattern.matcher(template);

        StringBuffer result = new StringBuffer();
        while (matcher.find()) {
            int a = Integer.parseInt(matcher.group(1));
            int b = Integer.parseInt(matcher.group(2));
            matcher.appendReplacement(result, String.valueOf(a * b));
        }
        matcher.appendTail(result);

        return result.toString();
    }


    private ResponseEntity<String> error(String message) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
    }
}