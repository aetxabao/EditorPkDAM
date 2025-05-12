package edu.masanz.da.epk.controller;

import io.javalin.http.Context;

import java.util.HashMap;
import java.util.Map;

public class EditorController {

    public static void iniciar(Context context) {
        Map<String, Object> model = new HashMap<>();
        context.render("/templates/editor.ftl", model);
    }

}
