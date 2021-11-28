package com.webapp;

/**
 * @author avivy
 * @date 11/26/2021
 * @filename EssayService.java
 **/



import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class EssayService  implements Serializable {

    public String writeEssay(String essayText) {

        return essayText;
    }
}
