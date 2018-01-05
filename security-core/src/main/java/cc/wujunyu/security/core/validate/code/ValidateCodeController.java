package cc.wujunyu.security.core.validate.code;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class ValidateCodeController {

    protected static final String SESSION_KEY = "SESSION_KEY_IMAGE_CODE";
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ImageCode imageCode = createImageCode(request);
        sessionStrategy.setAttribute(new ServletWebRequest(request), SESSION_KEY, imageCode);
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());
    }

    private ImageCode createImageCode(HttpServletRequest request) {
        BufferedImage image = new  BufferedImage(49,14,BufferedImage.TYPE_INT_RGB);
        Graphics  g = image.getGraphics();
        g.fillRect(0,1,67,23);
        g.setColor(Color.black);
        String random = RandomStringUtils.randomNumeric(4);
        g.drawString(random,4,11);
        g.dispose();
        return new ImageCode(image, random, 60);
    }

}
