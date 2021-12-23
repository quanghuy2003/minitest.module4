package formatter;


import model.Clasz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import service.IClaszService;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ClaszFormatter implements Formatter<Clasz>{
    private IClaszService iClaszService;

    @Autowired
    public ClaszFormatter(IClaszService iClaszService) {
        this.iClaszService = iClaszService;
    }

    @Override
    public Clasz parse(String text, Locale locale) throws ParseException {
        Optional<Clasz> provinceOptional = iClaszService.findById(Long.parseLong(text));
        return provinceOptional.orElse(null);
    }

    @Override
    public String print(Clasz object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
