import javax.xml.bind.*;
import namensraum.mein.*;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        RECHNUNGEN rechnungen;
        try {
            JAXBContext context = JAXBContext.newInstance("rechnungen");
            Unmarshaller unmarshaller = context.createUnmarshaller();
            rechnungen = (RECHNUNGEN) JAXBIntrospector.getValue(
                    unmarshaller.unmarshal(new File("dekAufgabe4\\src\\rechnungen\\rechnungen.xml"))
            );
        } catch (JAXBException e) {
            System.err.println("Fehler beim Initialisieren des Unmarshallers!");
            System.out.println();
            e.printStackTrace();
            return;
        }

        for (RECHNUNGEN.RECHNUNG rechnung : rechnungen.getRECHNUNG()) {
            System.out.println(rechnung.getLEISTUNGSEMPFAENGER().getVOLLSTNAME() + ".");
            System.out.println("Bitte zahlen Sie endlich den geforderten Betrag");
            System.out.println("von "+rechnung.getENTGELD().getRECHNUNGSBETRAG() +" Euro auf das Konto");

            RECHNUNGEN.RECHNUNG.ZAHLUNGSMOEGLICHKEITEN zahlungsart = rechnung.getZAHLUNGSMOEGLICHKEITEN();

            if ( zahlungsart.getBANK() != null) {
                System.out.println( zahlungsart.getBANK() +
                        ", Konto Nr:" + zahlungsart.getKONTONUMMER() +
                        ", IBAN: " + zahlungsart.getIBAN() +
                        ", BIC: " + zahlungsart.getBIC() + " ein.");
            }
            else if ( zahlungsart.getBITCOIN() != null) {
                System.out.println( "Bitcoin: " + zahlungsart.getBITCOIN() + "ein.");
            }
            System.out.println("Falls Sie trotzdem noch unverschämt genug sind");
            System.out.println("und Fragen haben, dann können Sie mich jederzeit");
            System.out.println("unter "+ rechnung.getAusstellung().getTelephone() +" erreichen.");
            System.out.println("Hochachtungsvoll");
            System.out.println(rechnung.getAusstellung().getAussteller());
        }

    }
}