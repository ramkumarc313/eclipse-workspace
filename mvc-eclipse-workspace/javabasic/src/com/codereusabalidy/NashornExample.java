package com.codereusabalidy;

import java.io.FileReader;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class NashornExample {
    public static void main(String[] args) throws Exception{  
        // Creating script engine  
        ScriptEngine ee = new ScriptEngineManager().getEngineByName("Nashorn");  
        //Binding script and Define scope of script  
        Bindings bind = ee.getBindings(ScriptContext.ENGINE_SCOPE);  
        bind.put("name", "Nashorn");  
        // Reading Nashorn file  
        ee.eval(new FileReader("D:\\Developer\\mvc-eclipse-workspace\\javabasic\\src\\hello.js"));  
    }  


}
