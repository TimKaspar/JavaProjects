package ch.ti8m.azubi.kti.pizzashop.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import org.junit.Assert;
import org.junit.Test;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class FreemarkerTest {
    private Configuration configuration() {
        Configuration config = new Configuration();
        config.setDefaultEncoding("UTF-8");
        config.setLocale(Locale.getDefault());
        config.setClassForTemplateLoading(getClass(), "/templates");
        config.setIncompatibleImprovements(new Version(2, 3, 20));
        config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        return config;
    }

    /*@Test
    public void helloWorld() throws Exception {

        Template template = configuration().getTemplate("hello.ftl");

        Map<String, Object> model = new HashMap<>();
        model.put("name", "World");

        StringWriter writer = new StringWriter();
        template.process(model, writer);

        Assert.assertEquals("Hello World", writer.toString());
    }*/
}
