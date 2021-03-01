package com.nagarro.nagp.urbanclap.Usermanagement.Utils;

import com.nagarro.nagp.urbanclap.Usermanagement.Constants.UMSConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TokenUtils {
    public static final Logger LOGGER = LoggerFactory.getLogger(TokenUtils.class);

    @Autowired
    private MessageSource messageSource;

    private static SecureRandom random = new SecureRandom();
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER_CHAR = "!@#$%&*()_+-=[]?";
    private static final String Token_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;
    private static final String Token_ALLOW_BASE_SHUFFLE = shuffleString(Token_ALLOW_BASE);
    private static final String Token_ALLOW = Token_ALLOW_BASE_SHUFFLE;

    public static String hashToken(String Token) throws Exception {

        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            LOGGER.info("Exception while hashing Token", e);
            throw new Exception("Error occurred while hashing Token : {}" + e.getMessage());
        }
        byte[] hash = digest.digest(Token.getBytes(StandardCharsets.UTF_8));

        return Base64.getEncoder().encodeToString(hash);
    }

    public static String generateToken() {
        return generateRandomToken(UMSConstants.PSWD_LENGTH);
    }

    private static String generateRandomToken(int length) {
        String pass = mandateCriteria();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length - 4; i++) {
            int rndCharAt = random.nextInt(Token_ALLOW.length());
            char rndChar = Token_ALLOW.charAt(rndCharAt);
            sb.append(rndChar);
        }
        pass += sb.toString();
        return shuffleString(pass);
    }

    // shuffle
    public static String shuffleString(String string) {
        List<String> letters = Arrays.asList(string.split(""));
        Collections.shuffle(letters);
        return letters.stream().collect(Collectors.joining());
    }

    private static String mandateCriteria() {
        String pass = "";
        int rndCharAt = random.nextInt(CHAR_LOWER.length());
        pass += CHAR_LOWER.charAt(rndCharAt);
        rndCharAt = random.nextInt(CHAR_UPPER.length());
        pass += CHAR_UPPER.charAt(rndCharAt);
        rndCharAt = random.nextInt(OTHER_CHAR.length());
        pass += OTHER_CHAR.charAt(rndCharAt);
        rndCharAt = random.nextInt(NUMBER.length());
        pass += NUMBER.charAt(rndCharAt);
        return pass;
    }
}
