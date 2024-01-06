<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <!-- Match the RECHNUNG elements where Ausstellungsdatum is greater than 2010 -->
    <xsl:template match="RECHNUNG[number(translate(substring(AUSSTELLUNGSDATUM, 1, 4), '-', '')) > 2010]">
        <xsl:copy>
            <!-- Copy Ausstellungsdatum, Rechnungsnummer, and Rechnungsgesamtbruttobetrag -->
            <!--xsl:copy-of select="AUSSTELLUNGSDATUM"/>
            <xsl:copy-of select="RECHNUNGSNUMMER"/>
            <xsl:copy-of select="ENTGELD/RECHNUNGSBETRAG"/-->

            <!-- Copy LEISTUNGSEMPFAENGER/ANSCHRIFT only if ANREDE starts with 'Herr' or 'Frau' -->
            <!--xsl:if test="LEISTUNGSEMPFAENGER/ANREDE[starts-with(., 'Herr') or starts-with(., 'Frau')]">
                <xsl:copy-of select="LEISTUNGSEMPFAENGER/ANSCHRIFT"/>
            </xsl:if-->

            <!-- Copy each Rechnungsposition with position number, description, and Gesamtpreis -->
            <!--xsl:for-each select="LEISTUNGEN/LEISTUNG">
                <xsl:copy>
                    <POSITIONSNUMMER><xsl:value-of select="position()"/></POSITIONSNUMMER>
                    <BESCHREIBUNG><xsl:value-of select="PRODUKT"/></BESCHREIBUNG>
                    <GESAMTPREIS><xsl:value-of select="GESAMTPREIS"/></GESAMTPREIS>
                </xsl:copy>
            </xsl:for-each-->
        </xsl:copy>
    </xsl:template>



</xsl:stylesheet>
