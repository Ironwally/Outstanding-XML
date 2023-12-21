import javax.xml.bind.*;

import java.io.File;
import files.jaxb.*;

public class Main {
    public static void main(String[] args) {
        RECHNUNGEN rechnungen;
        try {
            JAXBContext context = JAXBContext.newInstance(RECHNUNGEN.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            rechnungen = (RECHNUNGEN) JAXBIntrospector.getValue(
                    unmarshaller.unmarshal(new File("src/rechnungen/TolleXMLRechnungen.xml"))
            );
        } catch (JAXBException e) {
            System.err.println("Fehler beim Initialisieren des Unmarshallers!");
            System.out.println();
            e.printStackTrace();
            return;
        }

        for (RECHNUNGEN.RECHNUNG rechnung : rechnungen.getRECHNUNG()) {
            if(rechnung.getLEISTUNGSEMPFAENGER().getANREDE() != null) { System.out.println(rechnung.getLEISTUNGSEMPFAENGER().getANREDE() + " " + rechnung.getLEISTUNGSEMPFAENGER().getVOLLSTNAME() + "."); }
            else { System.out.println("Sehr geehrte/r: " + rechnung.getLEISTUNGSEMPFAENGER().getVOLLSTNAME() + "."); }
            System.out.println("Bitte zahlen Sie endlich den geforderten Betrag");
            System.out.println("von "+rechnung.getENTGELD().getRECHNUNGSBETRAG() +" Euro auf das Konto");

            RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN zahlungsart = rechnung.getZAHLUNGSMOEGLICHKEITEN();

            if ( zahlungsart.getIBAN() != null && !zahlungsart.getIBAN().isEmpty()) {
                System.out.println("IBAN: " + zahlungsart.getIBAN());
            }
            else if ( zahlungsart.getBANK() != null && zahlungsart.getKONTONUMMER() != null) {
                System.out.print(zahlungsart.getBANK() + ", " + zahlungsart.getKONTONUMMER());
                if(zahlungsart.getBIC() != null) { System.out.print(zahlungsart.getBIC()); }
                System.out.println(" ein.");
            }
            else {
                System.out.println( "Bitcoin: " + zahlungsart.getBITCOIN() + "ein.");
            }
            if (rechnung.getUNTERNEHMEN().getTELEPHONE() != null) {
                System.out.println("Falls Sie trotzdem noch unverschämt genug sind");
                System.out.println("und Fragen haben, dann können Sie mich jederzeit");
                System.out.println("unter "+ rechnung.getUNTERNEHMEN().getTELEPHONE() +" erreichen.");
            }
            System.out.println("Hochachtungsvoll");
            System.out.println(rechnung.getUNTERNEHMEN().getNAME());
            System.out.println();
        }

    }
}


















//
     //                   ", Konto Nr:" + zahlungsart.getKONTONUMMER() +