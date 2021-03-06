<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:output method="html"/>
    <xsl:template match="/">
        <xsl:apply-templates select="greeting"/>
    </xsl:template>
    <xsl:template match="greeting">
        <html>
            <head>
                <title>Primera página</title>
            </head>
            <body>
                <h1>
                    <xsl:value-of select="."/>
                </h1>
                <br/>
                <h1>
                    <xsl:value-of select="@valor"/>
                </h1>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
