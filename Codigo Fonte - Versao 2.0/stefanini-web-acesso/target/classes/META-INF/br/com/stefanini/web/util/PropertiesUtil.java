package br.com.stefanini.web.util;

/**
 * Stefanini 2020
 * @author Ximenes
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil
{

    public PropertiesUtil()
    {
    }

    public Properties getConf(String appName, String fileName)
        throws FileNotFoundException, IOException
    {
        File file = null;
        if(dir != null)
        {
            file = new File((new StringBuilder()).append(dir).append("/").append(appName).append("/").append(fileName).toString());
        } else
        {
            file = new File((new StringBuilder()).append("/oracle/").append(appName).append("/").append(fileName).toString());
            if(!file.exists())
                file = new File((new StringBuilder()).append("c:/oracle/").append(appName).append("/").append(fileName).toString());
        }
        Properties props = new Properties();
        props.load(new FileInputStream(file));
        return props;
    }

    private static String dir = System.getProperty("app.conf.dir");

}