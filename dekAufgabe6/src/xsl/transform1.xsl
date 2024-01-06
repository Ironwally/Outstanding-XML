<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">


    <xsl:template match="/RECHNUNGEN">
        <xsl:text>&#10;</xsl:text> <!-- Line break -->
        <xsl:copy>
            <xsl:text>&#10;</xsl:text> <!-- Line break -->
            <xsl:for-each select="RECHNUNG">
                <!--xsl:if test="AUSSTELLUNGSDATUM[number(concat(substring-before(AUSSTELLUNGSDATUM,'-'), ' ')) = number(concat(substring-before(AUSSTELLUNGSDATUM,'-'), ' '))]"-->
                <xsl:copy>
                    <xsl:text>&#10;</xsl:text> <!-- Line break -->
                    <AUSSTELLUNGSDATUM><xsl:value-of select="AUSSTELLUNGSDATUM"/></AUSSTELLUNGSDATUM>
                    <xsl:text>&#10;</xsl:text> <!-- Line break -->
                    <RECHNUNGSNUMMER><xsl:value-of select="RECHNUNGSNUMMER"/></RECHNUNGSNUMMER>
                    <xsl:text>&#10;</xsl:text> <!-- Line break -->
                    <ENTGELD>
                        <xsl:text>&#10;</xsl:text> <!-- Line break -->
                        <RECHNUNGSBETRAG><xsl:value-of select="ENTGELD/RECHNUNGSBETRAG"/></RECHNUNGSBETRAG>
                        <xsl:text>&#10;</xsl:text> <!-- Line break -->
                    </ENTGELD>
                    <xsl:text>&#10;</xsl:text> <!-- Line break -->
                </xsl:copy>
                <xsl:text>&#10;</xsl:text> <!-- Line break -->
                <xsl:text>&#10;</xsl:text> <!-- Line break -->
                <!--/xsl:if-->
            </xsl:for-each>
        </xsl:copy>
    </xsl:template>
</xsl:stylesheet>