package ee.project;

/**
 * Created by IntelliJ IDEA.
 * User: root
 * Date: 11/23/11
 * Time: 8:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class Piir {

    public static String SQL = "CREATE TABLE RIIGI_ADMIN_YKSUSE_LIIK (\n" +
            "       riigi_admin_yksuse_lik_id INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       kood                 VARCHAR(10) NOT NULL,\n" +
            "       nimetus              VARCHAR(100) NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       alates               DATE NOT NULL,\n" +
            "       kuni                 DATE NOT NULL,\n" +
            "       PRIMARY KEY (riigi_admin_yksuse_lik_id)\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKRIIGI_ADMIN_YKSUSE_LIIK ON RIIGI_ADMIN_YKSUSE_LIIK\n" +
            "(\n" +
            "       riigi_admin_yksuse_lik_id\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE RIIGI_ADMIN_YKSUS (\n" +
            "       riigi_admin_yksus_ID INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       kood                 VARCHAR(20),\n" +
            "       nimetus              VARCHAR(100),\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       alates               DATE NOT NULL,\n" +
            "       kuni                 DATE NOT NULL,\n" +
            "       riigi_admin_yksuse_lik_id INTEGER NOT NULL,\n" +
            "       PRIMARY KEY (riigi_admin_yksus_ID), \n" +
            "       FOREIGN KEY (riigi_admin_yksuse_lik_id)\n" +
            "                             REFERENCES RIIGI_ADMIN_YKSUSE_LIIK\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKRIIGI_ADMIN_YKSUS ON RIIGI_ADMIN_YKSUS\n" +
            "(\n" +
            "       riigi_admin_yksus_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF5RIIGI_ADMIN_YKSUS ON RIIGI_ADMIN_YKSUS\n" +
            "(\n" +
            "       riigi_admin_yksuse_lik_id\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE VAEOSA (\n" +
            "       vaeosa_ID_id         INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       kood                 VARCHAR(20) NOT NULL,\n" +
            "       nimetus              VARCHAR(100) NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       riigi_admin_yksus_ID INTEGER NOT NULL,\n" +
            "       alates               DATE NOT NULL,\n" +
            "       kuni                 DATE NOT NULL,\n" +
            "       PRIMARY KEY (vaeosa_ID_id), \n" +
            "       FOREIGN KEY (riigi_admin_yksus_ID)\n" +
            "                             REFERENCES RIIGI_ADMIN_YKSUS\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKVAEOSA ON VAEOSA\n" +
            "(\n" +
            "       vaeosa_ID_id\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF1VAEOSA ON VAEOSA\n" +
            "(\n" +
            "       riigi_admin_yksus_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE PIIRIPUNKT (\n" +
            "       piiripunkt_ID        INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       kood                 VARCHAR(20) NOT NULL,\n" +
            "       nimetus              VARCHAR(100) NOT NULL,\n" +
            "       GPS_Longituide       DECIMAL(9) NOT NULL,\n" +
            "       GPS_latitude         DECIMAL(9) NOT NULL,\n" +
            "       korgus_merepinnast   DECIMAL(6) NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       alates               DATE NOT NULL,\n" +
            "       kuni                 DATE NOT NULL,\n" +
            "       PRIMARY KEY (piiripunkt_ID)\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKPIIRIPUNKT ON PIIRIPUNKT\n" +
            "(\n" +
            "       piiripunkt_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE VAHTKOND (\n" +
            "       vahtkond_ID          INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       kood                 VARCHAR(20),\n" +
            "       nimetus              VARCHAR(60),\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       alates               DATE,\n" +
            "       kuni                 DATE,\n" +
            "       piiripunkt_ID        INTEGER,\n" +
            "       vaeosa_ID_id         INTEGER,\n" +
            "       PRIMARY KEY (vahtkond_ID), \n" +
            "       FOREIGN KEY (vaeosa_ID_id)\n" +
            "                             REFERENCES VAEOSA\n" +
            "                             ON DELETE SET NULL, \n" +
            "       FOREIGN KEY (piiripunkt_ID)\n" +
            "                             REFERENCES PIIRIPUNKT\n" +
            "                             ON DELETE SET NULL\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKVAHTKOND ON VAHTKOND\n" +
            "(\n" +
            "       vahtkond_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF41VAHTKOND ON VAHTKOND\n" +
            "(\n" +
            "       piiripunkt_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF42VAHTKOND ON VAHTKOND\n" +
            "(\n" +
            "       vaeosa_ID_id\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE INTSIDENDI_LIIK (\n" +
            "       intsidendi_liik_ID   INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       kood                 CHAR(18),\n" +
            "       nimetus              VARCHAR(60),\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       PRIMARY KEY (intsidendi_liik_ID)\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKINTSIDENDI_LIIK ON INTSIDENDI_LIIK\n" +
            "(\n" +
            "       intsidendi_liik_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE PIIRILOIK (\n" +
            "       piiriloik_ID         INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       kood                 CHAR(18),\n" +
            "       nimetus              VARCHAR(60),\n" +
            "       GPS_koordinaadid     LONGVARCHAR,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       PRIMARY KEY (piiriloik_ID)\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKPIIRILOIK ON PIIRILOIK\n" +
            "(\n" +
            "       piiriloik_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE INTSIDENT (\n" +
            "       intsident_ID         INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       kood                 VARCHAR(20),\n" +
            "       nimetus              VARCHAR(100),\n" +
            "       toimumise_algus      DATE,\n" +
            "       toimumise_lopp       DATE,\n" +
            "       kirjeldus            LONGVARCHAR,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       piiriloik_ID         INTEGER,\n" +
            "       intsidendi_liik_ID   INTEGER NOT NULL,\n" +
            "       GPS_longituud        DECIMAL(9),\n" +
            "       GPS_latituud         DECIMAL(9),\n" +
            "       PRIMARY KEY (intsident_ID), \n" +
            "       FOREIGN KEY (intsidendi_liik_ID)\n" +
            "                             REFERENCES INTSIDENDI_LIIK\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (piiriloik_ID)\n" +
            "                             REFERENCES PIIRILOIK\n" +
            "                             ON DELETE SET NULL\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKINTSIDENT ON INTSIDENT\n" +
            "(\n" +
            "       intsident_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF51INTSIDENT ON INTSIDENT\n" +
            "(\n" +
            "       piiriloik_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF52INTSIDENT ON INTSIDENT\n" +
            "(\n" +
            "       intsidendi_liik_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE VAHTKOND_INTSIDENDIS (\n" +
            "       vahtkond_intsidendis_ID INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       alates               DATE,\n" +
            "       kuni                 DATE,\n" +
            "       kirjeldus            LONGVARCHAR,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       intsident_ID         INTEGER NOT NULL,\n" +
            "       vahtkond_ID          INTEGER,\n" +
            "       PRIMARY KEY (vahtkond_intsidendis_ID), \n" +
            "       FOREIGN KEY (vahtkond_ID)\n" +
            "                             REFERENCES VAHTKOND\n" +
            "                             ON DELETE SET NULL, \n" +
            "       FOREIGN KEY (intsident_ID)\n" +
            "                             REFERENCES INTSIDENT\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKVAHTKOND_INTSIDENDIS ON VAHTKOND_INTSIDENDIS\n" +
            "(\n" +
            "       vahtkond_intsidendis_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF53VAHTKOND_INTSIDENDIS ON VAHTKOND_INTSIDENDIS\n" +
            "(\n" +
            "       intsident_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF54VAHTKOND_INTSIDENDIS ON VAHTKOND_INTSIDENDIS\n" +
            "(\n" +
            "       vahtkond_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE PIIRIVALVUR (\n" +
            "       piirivalvur_ID       INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       isikukood            VARCHAR(20),\n" +
            "       eesnimed             VARCHAR(25),\n" +
            "       perekonnanimi        VARCHAR(35),\n" +
            "       sugu                 CHAR(1),\n" +
            "       soduri_kood          VARCHAR(20),\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       PRIMARY KEY (piirivalvur_ID)\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKPIIRIVALVUR ON PIIRIVALVUR\n" +
            "(\n" +
            "       piirivalvur_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE PiIRIVALVUR_INTSIDENDIS (\n" +
            "       piirivalvur_intsidendis_ID INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       alates               DATE,\n" +
            "       kuni                 DATE,\n" +
            "       kirjeldus            LONGVARCHAR,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       intsident_ID         INTEGER,\n" +
            "       piirivalvur_ID       INTEGER NOT NULL,\n" +
            "       vahtkond_intsidendis_ID INTEGER,\n" +
            "       PRIMARY KEY (piirivalvur_intsidendis_ID), \n" +
            "       FOREIGN KEY (vahtkond_intsidendis_ID)\n" +
            "                             REFERENCES VAHTKOND_INTSIDENDIS\n" +
            "                             ON DELETE SET NULL, \n" +
            "       FOREIGN KEY (piirivalvur_ID)\n" +
            "                             REFERENCES PIIRIVALVUR\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (intsident_ID)\n" +
            "                             REFERENCES INTSIDENT\n" +
            "                             ON DELETE SET NULL\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKPiIRIVALVUR_INTSIDENDIS ON PiIRIVALVUR_INTSIDENDIS\n" +
            "(\n" +
            "       piirivalvur_intsidendis_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF55PiIRIVALVUR_INTSIDENDIS ON PiIRIVALVUR_INTSIDENDIS\n" +
            "(\n" +
            "       intsident_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF56PiIRIVALVUR_INTSIDENDIS ON PiIRIVALVUR_INTSIDENDIS\n" +
            "(\n" +
            "       piirivalvur_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF57PiIRIVALVUR_INTSIDENDIS ON PiIRIVALVUR_INTSIDENDIS\n" +
            "(\n" +
            "       vahtkond_intsidendis_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE RUUMIYKSUSE_LIIK (\n" +
            "       ruumiyksuse_liik_ID  INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       kood                 VARCHAR(20),\n" +
            "       nimetus              VARCHAR(60),\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       PRIMARY KEY (ruumiyksuse_liik_ID)\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKRUUMIYKSUSE_LIIK ON RUUMIYKSUSE_LIIK\n" +
            "(\n" +
            "       ruumiyksuse_liik_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE RUUMIYKSUS (\n" +
            "       ruumiyksus_ID        INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       aadress              CHAR(18),\n" +
            "       nimetus              CHAR(18),\n" +
            "       kommentaar           CHAR(18),\n" +
            "       kood                 CHAR(18),\n" +
            "       ruumiyksuse_liik_ID  INTEGER NOT NULL,\n" +
            "       ylem_ruumiyksus_ID   INTEGER,\n" +
            "       riigi_admin_yksus_ID INTEGER,\n" +
            "       PRIMARY KEY (ruumiyksus_ID), \n" +
            "       FOREIGN KEY (riigi_admin_yksus_ID)\n" +
            "                             REFERENCES RIIGI_ADMIN_YKSUS\n" +
            "                             ON DELETE SET NULL, \n" +
            "       FOREIGN KEY (ylem_ruumiyksus_ID)\n" +
            "                             REFERENCES RUUMIYKSUS\n" +
            "                             ON DELETE SET NULL, \n" +
            "       FOREIGN KEY (ruumiyksuse_liik_ID)\n" +
            "                             REFERENCES RUUMIYKSUSE_LIIK\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKRUUMIYKSUS ON RUUMIYKSUS\n" +
            "(\n" +
            "       ruumiyksus_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF45RUUMIYKSUS ON RUUMIYKSUS\n" +
            "(\n" +
            "       ruumiyksuse_liik_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF46RUUMIYKSUS ON RUUMIYKSUS\n" +
            "(\n" +
            "       ylem_ruumiyksus_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF50RUUMIYKSUS ON RUUMIYKSUS\n" +
            "(\n" +
            "       riigi_admin_yksus_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE VOODIKOHT (\n" +
            "       voodikoht_ID         INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       number               VARCHAR(20),\n" +
            "       pikkus               INTEGER,\n" +
            "       laius                INTEGER,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       ruumiyksus_ID        INTEGER NOT NULL,\n" +
            "       PRIMARY KEY (voodikoht_ID), \n" +
            "       FOREIGN KEY (ruumiyksus_ID)\n" +
            "                             REFERENCES RUUMIYKSUS\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKVOODIKOHT ON VOODIKOHT\n" +
            "(\n" +
            "       voodikoht_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF47VOODIKOHT ON VOODIKOHT\n" +
            "(\n" +
            "       ruumiyksus_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE PIIRIVALVUR_VODIKOHAL (\n" +
            "       _id                  INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       voodikoht_ID         INTEGER NOT NULL,\n" +
            "       piirivalvur_ID       INTEGER NOT NULL,\n" +
            "       alates               DATE,\n" +
            "       kuni                 DATE,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       PRIMARY KEY (_id), \n" +
            "       FOREIGN KEY (piirivalvur_ID)\n" +
            "                             REFERENCES PIIRIVALVUR\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (voodikoht_ID)\n" +
            "                             REFERENCES VOODIKOHT\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKPIIRIVALVUR_VODIKOHAL ON PIIRIVALVUR_VODIKOHAL\n" +
            "(\n" +
            "       _id\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF48PIIRIVALVUR_VODIKOHAL ON PIIRIVALVUR_VODIKOHAL\n" +
            "(\n" +
            "       voodikoht_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF49PIIRIVALVUR_VODIKOHAL ON PIIRIVALVUR_VODIKOHAL\n" +
            "(\n" +
            "       piirivalvur_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE VAHTKONNA_LIIGE (\n" +
            "       vahtkonna_liige_ID   INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       vahtkond_ID          INTEGER NOT NULL,\n" +
            "       piirivalvur_ID       INTEGER NOT NULL,\n" +
            "       alates               CHAR(18),\n" +
            "       kuni                 CHAR(18),\n" +
            "       kommentaar           CHAR(18),\n" +
            "       PRIMARY KEY (vahtkonna_liige_ID), \n" +
            "       FOREIGN KEY (piirivalvur_ID)\n" +
            "                             REFERENCES PIIRIVALVUR\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (vahtkond_ID)\n" +
            "                             REFERENCES VAHTKOND\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKVAHTKONNA_LIIGE ON VAHTKONNA_LIIGE\n" +
            "(\n" +
            "       vahtkonna_liige_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF43VAHTKONNA_LIIGE ON VAHTKONNA_LIIGE\n" +
            "(\n" +
            "       vahtkond_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF44VAHTKONNA_LIIGE ON VAHTKONNA_LIIGE\n" +
            "(\n" +
            "       piirivalvur_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE VAHTKONND_PIIRILOIGUL (\n" +
            "       vahtkond_piiriloiul_ID INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       piiriloik_ID         INTEGER NOT NULL,\n" +
            "       vahtkond_ID          INTEGER NOT NULL,\n" +
            "       alates               DATE,\n" +
            "       kuni                 DATE,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       PRIMARY KEY (vahtkond_piiriloiul_ID), \n" +
            "       FOREIGN KEY (vahtkond_ID)\n" +
            "                             REFERENCES VAHTKOND\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (piiriloik_ID)\n" +
            "                             REFERENCES PIIRILOIK\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKVAHTKONND_PIIRILOIGUL ON VAHTKONND_PIIRILOIGUL\n" +
            "(\n" +
            "       vahtkond_piiriloiul_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF39VAHTKONND_PIIRILOIGUL ON VAHTKONND_PIIRILOIGUL\n" +
            "(\n" +
            "       piiriloik_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF40VAHTKONND_PIIRILOIGUL ON VAHTKONND_PIIRILOIGUL\n" +
            "(\n" +
            "       vahtkond_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE OBJEKTI_LIIK (\n" +
            "       objekt_liik_ID       INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       nimetus              VARCHAR(100) NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       kood                 CHAR(18),\n" +
            "       PRIMARY KEY (objekt_liik_ID)\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKOBJEKTI_LIIK ON OBJEKTI_LIIK\n" +
            "(\n" +
            "       objekt_liik_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE OBJEKT (\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       nimetus              VARCHAR(100),\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       objekt_ID            INTEGER,\n" +
            "       objekt_liik_ID       INTEGER NOT NULL,\n" +
            "       PRIMARY KEY (objekt_ID), \n" +
            "       FOREIGN KEY (objekt_liik_ID)\n" +
            "                             REFERENCES OBJEKTI_LIIK\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKOBJEKT ON OBJEKT\n" +
            "(\n" +
            "       objekt_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF58OBJEKT ON OBJEKT\n" +
            "(\n" +
            "       objekt_liik_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE AMET (\n" +
            "       amet_ID              INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       ISCO_kood            VARCHAR(10),\n" +
            "       nimetus              VARCHAR(60),\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       PRIMARY KEY (amet_ID)\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKAMET ON AMET\n" +
            "(\n" +
            "       amet_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE AMET_PIIRIPUNKTIS (\n" +
            "       amet_piiripunktis_ID INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       alates               DATE NOT NULL,\n" +
            "       kuni                 DATE NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       piiripunkt_ID        INTEGER NOT NULL,\n" +
            "       amet_ID              INTEGER NOT NULL,\n" +
            "       PRIMARY KEY (amet_piiripunktis_ID), \n" +
            "       FOREIGN KEY (amet_ID)\n" +
            "                             REFERENCES AMET\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (piiripunkt_ID)\n" +
            "                             REFERENCES PIIRIPUNKT\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKAMET_PIIRIPUNKTIS ON AMET_PIIRIPUNKTIS\n" +
            "(\n" +
            "       amet_piiripunktis_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF30AMET_PIIRIPUNKTIS ON AMET_PIIRIPUNKTIS\n" +
            "(\n" +
            "       piiripunkt_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF31AMET_PIIRIPUNKTIS ON AMET_PIIRIPUNKTIS\n" +
            "(\n" +
            "       amet_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE PIIRIVALVUR_PIIRIPUNKTIS (\n" +
            "       piirivalvur_piiripunktis_ID INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       alates               DATE NOT NULL,\n" +
            "       kuni                 DATE NOT NULL,\n" +
            "       koormus              DECIMAL(5) NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       piirivalvur_ID       INTEGER NOT NULL,\n" +
            "       amet_piiripunktis_ID INTEGER NOT NULL,\n" +
            "       PRIMARY KEY (piirivalvur_piiripunktis_ID), \n" +
            "       FOREIGN KEY (piirivalvur_ID)\n" +
            "                             REFERENCES PIIRIVALVUR\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (amet_piiripunktis_ID)\n" +
            "                             REFERENCES AMET_PIIRIPUNKTIS\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKPIIRIVALVUR_PIIRIPUNKTIS ON PIIRIVALVUR_PIIRIPUNKTIS\n" +
            "(\n" +
            "       piirivalvur_piiripunktis_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF34PIIRIVALVUR_PIIRIPUNKTIS ON PIIRIVALVUR_PIIRIPUNKTIS\n" +
            "(\n" +
            "       amet_piiripunktis_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF35PIIRIVALVUR_PIIRIPUNKTIS ON PIIRIVALVUR_PIIRIPUNKTIS\n" +
            "(\n" +
            "       piirivalvur_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE AMET_VAEOSAS (\n" +
            "       amet_vaeosas_ID      INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       alates               DATE NOT NULL,\n" +
            "       kuni                 DATE NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       vaeosa_ID_id         INTEGER NOT NULL,\n" +
            "       amet_ID              INTEGER NOT NULL,\n" +
            "       PRIMARY KEY (amet_vaeosas_ID), \n" +
            "       FOREIGN KEY (amet_ID)\n" +
            "                             REFERENCES AMET\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (vaeosa_ID_id)\n" +
            "                             REFERENCES VAEOSA\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKAMET_VAEOSAS ON AMET_VAEOSAS\n" +
            "(\n" +
            "       amet_vaeosas_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF28AMET_VAEOSAS ON AMET_VAEOSAS\n" +
            "(\n" +
            "       vaeosa_ID_id\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF29AMET_VAEOSAS ON AMET_VAEOSAS\n" +
            "(\n" +
            "       amet_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE PIIRIPUNKTI_ORG_YKSUS (\n" +
            "       piiripunkti_org_yksus_ID INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       kood                 VARCHAR(20) NOT NULL,\n" +
            "       nimetus              VARCHAR(100) NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       ylem_org_yksus_ID    INTEGER,\n" +
            "       vaeosa_ID_id         INTEGER NOT NULL,\n" +
            "       alates               DATE NOT NULL,\n" +
            "       kuni                 DATE NOT NULL,\n" +
            "       piiripunkt_ID        INTEGER NOT NULL,\n" +
            "       PRIMARY KEY (piiripunkti_org_yksus_ID), \n" +
            "       FOREIGN KEY (ylem_org_yksus_ID)\n" +
            "                             REFERENCES PIIRIPUNKTI_ORG_YKSUS\n" +
            "                             ON DELETE SET NULL, \n" +
            "       FOREIGN KEY (piiripunkt_ID)\n" +
            "                             REFERENCES PIIRIPUNKT\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKPIIRIPUNKTI_ORG_YKSUS ON PIIRIPUNKTI_ORG_YKSUS\n" +
            "(\n" +
            "       piiripunkti_org_yksus_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF25PIIRIPUNKTI_ORG_YKSUS ON PIIRIPUNKTI_ORG_YKSUS\n" +
            "(\n" +
            "       piiripunkt_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF26PIIRIPUNKTI_ORG_YKSUS ON PIIRIPUNKTI_ORG_YKSUS\n" +
            "(\n" +
            "       ylem_org_yksus_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE PIIRIVALVUR_VAEOSAS (\n" +
            "       piirivalvur_vaeosas_ID INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       alates               DATE,\n" +
            "       kuni                 DATE,\n" +
            "       koormus              DECIMAL(5),\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       piirivalvur_ID       INTEGER NOT NULL,\n" +
            "       amet_vaeosas_ID      INTEGER NOT NULL,\n" +
            "       PRIMARY KEY (piirivalvur_vaeosas_ID), \n" +
            "       FOREIGN KEY (amet_vaeosas_ID)\n" +
            "                             REFERENCES AMET_VAEOSAS\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (piirivalvur_ID)\n" +
            "                             REFERENCES PIIRIVALVUR\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKPIIRIVALVUR_VAEOSAS ON PIIRIVALVUR_VAEOSAS\n" +
            "(\n" +
            "       piirivalvur_vaeosas_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF32PIIRIVALVUR_VAEOSAS ON PIIRIVALVUR_VAEOSAS\n" +
            "(\n" +
            "       piirivalvur_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF33PIIRIVALVUR_VAEOSAS ON PIIRIVALVUR_VAEOSAS\n" +
            "(\n" +
            "       amet_vaeosas_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE SUGULUSE_ROLLI_LIIK (\n" +
            "       suguluse_rolli_liik_ID INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       nimetus              VARCHAR(60) NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR NOT NULL,\n" +
            "       sugulane_voi_mitte   CHAR(1),\n" +
            "       PRIMARY KEY (suguluse_rolli_liik_ID)\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKSUGULUSE_ROLLI_LIIK ON SUGULUSE_ROLLI_LIIK\n" +
            "(\n" +
            "       suguluse_rolli_liik_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE SEOTUD_KONTAKTISIK (\n" +
            "       piirivalvuri_kontakt_ID INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR NOT NULL,\n" +
            "       piirivalvur_ID       INTEGER NOT NULL,\n" +
            "       suguluse_rolli_liik_ID INTEGER NOT NULL,\n" +
            "       alates               DATE,\n" +
            "       kuni                 DATE,\n" +
            "       PRIMARY KEY (piirivalvuri_kontakt_ID), \n" +
            "       FOREIGN KEY (suguluse_rolli_liik_ID)\n" +
            "                             REFERENCES SUGULUSE_ROLLI_LIIK\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (piirivalvur_ID)\n" +
            "                             REFERENCES PIIRIVALVUR\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKSEOTUD_KONTAKTISIK ON SEOTUD_KONTAKTISIK\n" +
            "(\n" +
            "       piirivalvuri_kontakt_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF19SEOTUD_KONTAKTISIK ON SEOTUD_KONTAKTISIK\n" +
            "(\n" +
            "       piirivalvur_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF20SEOTUD_KONTAKTISIK ON SEOTUD_KONTAKTISIK\n" +
            "(\n" +
            "       suguluse_rolli_liik_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE KONTAKTI_LIIK (\n" +
            "       kontakti_liik_ID     INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       nimetus              VARCHAR(60) NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR NOT NULL,\n" +
            "       XML_kirjeldus        LONGVARCHAR,\n" +
            "       PRIMARY KEY (kontakti_liik_ID)\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKKONTAKTI_LIIK ON KONTAKTI_LIIK\n" +
            "(\n" +
            "       kontakti_liik_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE PIIRIVALVURI_KONTAKT (\n" +
            "       piirivalvuri_kontakt_ID INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       kontakt              VARCHAR(120) NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR NOT NULL,\n" +
            "       peamine_kontakt      VARCHAR(1),\n" +
            "       piirivalvur_ID       INTEGER NOT NULL,\n" +
            "       kontakti_liik_ID     INTEGER NOT NULL,\n" +
            "       alates               DATE,\n" +
            "       kuni                 DATE,\n" +
            "       PRIMARY KEY (piirivalvuri_kontakt_ID), \n" +
            "       FOREIGN KEY (kontakti_liik_ID)\n" +
            "                             REFERENCES KONTAKTI_LIIK\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (piirivalvur_ID)\n" +
            "                             REFERENCES PIIRIVALVUR\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKPIIRIVALVURI_KONTAKT ON PIIRIVALVURI_KONTAKT\n" +
            "(\n" +
            "       piirivalvuri_kontakt_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF17PIIRIVALVURI_KONTAKT ON PIIRIVALVURI_KONTAKT\n" +
            "(\n" +
            "       piirivalvur_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF18PIIRIVALVURI_KONTAKT ON PIIRIVALVURI_KONTAKT\n" +
            "(\n" +
            "       kontakti_liik_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE AUASTE (\n" +
            "       auaste_ID            INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       kood                 VARCHAR(20),\n" +
            "       nimetus              VARCHAR(60),\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       PRIMARY KEY (auaste_ID)\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKAUASTE ON AUASTE\n" +
            "(\n" +
            "       auaste_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE AUASTME_MUUTUMINE (\n" +
            "       auastme_muutumine_ID INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       piirivalvur_ID       INTEGER NOT NULL,\n" +
            "       auaste_ID            INTEGER NOT NULL,\n" +
            "       alates               DATE,\n" +
            "       kuni                 DATE,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       PRIMARY KEY (auastme_muutumine_ID), \n" +
            "       FOREIGN KEY (auaste_ID)\n" +
            "                             REFERENCES AUASTE\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (piirivalvur_ID)\n" +
            "                             REFERENCES PIIRIVALVUR\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKAUASTME_MUUTUMINE ON AUASTME_MUUTUMINE\n" +
            "(\n" +
            "       auastme_muutumine_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF15AUASTME_MUUTUMINE ON AUASTME_MUUTUMINE\n" +
            "(\n" +
            "       piirivalvur_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF16AUASTME_MUUTUMINE ON AUASTME_MUUTUMINE\n" +
            "(\n" +
            "       auaste_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE ADMIN_ALLUVUS (\n" +
            "       admin_alluvus_id     INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       alates               CHAR(18),\n" +
            "       kuni                 CHAR(18),\n" +
            "       kommentaar           CHAR(18),\n" +
            "       ylemus_yksus_ID      INTEGER NOT NULL,\n" +
            "       alluv_yksus_ID       INTEGER NOT NULL,\n" +
            "       PRIMARY KEY (admin_alluvus_id), \n" +
            "       FOREIGN KEY (alluv_yksus_ID)\n" +
            "                             REFERENCES RIIGI_ADMIN_YKSUS\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (ylemus_yksus_ID)\n" +
            "                             REFERENCES RIIGI_ADMIN_YKSUS\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKADMIN_ALLUVUS ON ADMIN_ALLUVUS\n" +
            "(\n" +
            "       admin_alluvus_id\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF3ADMIN_ALLUVUS ON ADMIN_ALLUVUS\n" +
            "(\n" +
            "       ylemus_yksus_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF4ADMIN_ALLUVUS ON ADMIN_ALLUVUS\n" +
            "(\n" +
            "       alluv_yksus_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE PIIRILOIGU_HALDAJA (\n" +
            "       piiriloigu_haldaja_ID INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       piiriloik_ID         INTEGER,\n" +
            "       piiripunkt_ID        INTEGER NOT NULL,\n" +
            "       vaeosa_ID_id         INTEGER NOT NULL,\n" +
            "       alates               DATE,\n" +
            "       kuni                 DATE,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       PRIMARY KEY (piiriloigu_haldaja_ID), \n" +
            "       FOREIGN KEY (vaeosa_ID_id)\n" +
            "                             REFERENCES VAEOSA\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (piiripunkt_ID)\n" +
            "                             REFERENCES PIIRIPUNKT\n" +
            "                             ON DELETE SET NULL, \n" +
            "       FOREIGN KEY (piiriloik_ID)\n" +
            "                             REFERENCES PIIRILOIK\n" +
            "                             ON DELETE SET NULL\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKPIIRILOIGU_HALDAJA ON PIIRILOIGU_HALDAJA\n" +
            "(\n" +
            "       piiriloigu_haldaja_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF36PIIRILOIGU_HALDAJA ON PIIRILOIGU_HALDAJA\n" +
            "(\n" +
            "       piiriloik_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF37PIIRILOIGU_HALDAJA ON PIIRILOIGU_HALDAJA\n" +
            "(\n" +
            "       piiripunkt_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF38PIIRILOIGU_HALDAJA ON PIIRILOIGU_HALDAJA\n" +
            "(\n" +
            "       vaeosa_ID_id\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE VOIMALIK_ALLUVUS (\n" +
            "       voimalik_alluvus_id  INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       riigi_admin_yksuse_lik_id INTEGER NOT NULL,\n" +
            "       voimalik_alluv_liik_ID INTEGER NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       PRIMARY KEY (voimalik_alluvus_id), \n" +
            "       FOREIGN KEY (voimalik_alluv_liik_ID)\n" +
            "                             REFERENCES RIIGI_ADMIN_YKSUSE_LIIK\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (riigi_admin_yksuse_lik_id)\n" +
            "                             REFERENCES RIIGI_ADMIN_YKSUSE_LIIK\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKVOIMALIK_ALLUVUS ON VOIMALIK_ALLUVUS\n" +
            "(\n" +
            "       voimalik_alluvus_id\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF6VOIMALIK_ALLUVUS ON VOIMALIK_ALLUVUS\n" +
            "(\n" +
            "       riigi_admin_yksuse_lik_id\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF7VOIMALIK_ALLUVUS ON VOIMALIK_ALLUVUS\n" +
            "(\n" +
            "       voimalik_alluv_liik_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE PIIRIPUNKTI_ALLUVUS (\n" +
            "       piiripunkti_alluvus_ID INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       alates               CHAR(18),\n" +
            "       kuni                 CHAR(18),\n" +
            "       kommentaar           CHAR(18),\n" +
            "       vaeosa_ID            INTEGER NOT NULL,\n" +
            "       piiripunkt_ID        INTEGER NOT NULL,\n" +
            "       PRIMARY KEY (piiripunkti_alluvus_ID), \n" +
            "       FOREIGN KEY (piiripunkt_ID)\n" +
            "                             REFERENCES PIIRIPUNKT\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (vaeosa_ID)\n" +
            "                             REFERENCES VAEOSA\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKPIIRIPUNKTI_ALLUVUS ON PIIRIPUNKTI_ALLUVUS\n" +
            "(\n" +
            "       piiripunkti_alluvus_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF10PIIRIPUNKTI_ALLUVUS ON PIIRIPUNKTI_ALLUVUS\n" +
            "(\n" +
            "       vaeosa_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF27PIIRIPUNKTI_ALLUVUS ON PIIRIPUNKTI_ALLUVUS\n" +
            "(\n" +
            "       piiripunkt_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE VAEOSA_ALLUVUS (\n" +
            "       vaeosa_alluvus_id    INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       ylemus_vaeosa_ID     INTEGER NOT NULL,\n" +
            "       alluva_vaeosa_ID     INTEGER NOT NULL,\n" +
            "       alates               DATE NOT NULL,\n" +
            "       kuni                 DATE NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       PRIMARY KEY (vaeosa_alluvus_id), \n" +
            "       FOREIGN KEY (alluva_vaeosa_ID)\n" +
            "                             REFERENCES VAEOSA\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (ylemus_vaeosa_ID)\n" +
            "                             REFERENCES VAEOSA\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKVAEOSA_ALLUVUS ON VAEOSA_ALLUVUS\n" +
            "(\n" +
            "       vaeosa_alluvus_id\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF8VAEOSA_ALLUVUS ON VAEOSA_ALLUVUS\n" +
            "(\n" +
            "       ylemus_vaeosa_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF9VAEOSA_ALLUVUS ON VAEOSA_ALLUVUS\n" +
            "(\n" +
            "       alluva_vaeosa_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE ORG_YKSUS (\n" +
            "       org_yksus_ID         INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       kood                 VARCHAR(20) NOT NULL,\n" +
            "       nimetus              VARCHAR(100) NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       ylem_org_yksus_ID    INTEGER,\n" +
            "       vaeosa_ID_id         INTEGER NOT NULL,\n" +
            "       alates               DATE NOT NULL,\n" +
            "       kuni                 DATE NOT NULL,\n" +
            "       PRIMARY KEY (org_yksus_ID), \n" +
            "       FOREIGN KEY (vaeosa_ID_id)\n" +
            "                             REFERENCES VAEOSA\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (ylem_org_yksus_ID)\n" +
            "                             REFERENCES ORG_YKSUS\n" +
            "                             ON DELETE SET NULL\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKORG_YKSUS ON ORG_YKSUS\n" +
            "(\n" +
            "       org_yksus_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF12ORG_YKSUS ON ORG_YKSUS\n" +
            "(\n" +
            "       ylem_org_yksus_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF13ORG_YKSUS ON ORG_YKSUS\n" +
            "(\n" +
            "       vaeosa_ID_id\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE SEADUS (\n" +
            "       seaduse_ID           INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       kood                 VARCHAR(20) NOT NULL,\n" +
            "       nimetus              VARCHAR(20) NOT NULL,\n" +
            "       kommentaar           VARCHAR(20) NOT NULL,\n" +
            "       kehtiv_alates        CHAR(18),\n" +
            "       kehtiv_kuni          CHAR(18),\n" +
            "       PRIMARY KEY (seaduse_ID)\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKSEADUS ON SEADUS\n" +
            "(\n" +
            "       seaduse_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE SEADUSE_PUNKT (\n" +
            "       seaduse_punkt_ID     INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       paragrahv            CHAR(18),\n" +
            "       pais                 CHAR(18),\n" +
            "       tekst                CHAR(18),\n" +
            "       kommentaar           CHAR(18),\n" +
            "       kehtiv_alates        CHAR(18),\n" +
            "       kehtiv_kuni          CHAR(18),\n" +
            "       seaduse_ID           INTEGER NOT NULL,\n" +
            "       ylemus_seaduse_punkt_ID INTEGER,\n" +
            "       PRIMARY KEY (seaduse_punkt_ID), \n" +
            "       FOREIGN KEY (ylemus_seaduse_punkt_ID)\n" +
            "                             REFERENCES SEADUSE_PUNKT\n" +
            "                             ON DELETE SET NULL, \n" +
            "       FOREIGN KEY (seaduse_ID)\n" +
            "                             REFERENCES SEADUS\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKSEADUSE_PUNKT ON SEADUSE_PUNKT\n" +
            "(\n" +
            "       seaduse_punkt_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF60SEADUSE_PUNKT ON SEADUSE_PUNKT\n" +
            "(\n" +
            "       seaduse_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF61SEADUSE_PUNKT ON SEADUSE_PUNKT\n" +
            "(\n" +
            "       ylemus_seaduse_punkt_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE OBJEKT_INTSIDENDIS (\n" +
            "       objekt_intsidendis_ID INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       intsident_ID         INTEGER NOT NULL,\n" +
            "       alates               DATE,\n" +
            "       kuni                 DATE,\n" +
            "       kirjeldus            LONGVARCHAR,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       objekt_ID            INTEGER NOT NULL,\n" +
            "       PRIMARY KEY (objekt_intsidendis_ID), \n" +
            "       FOREIGN KEY (intsident_ID)\n" +
            "                             REFERENCES INTSIDENT\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (objekt_ID)\n" +
            "                             REFERENCES OBJEKT\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKOBJEKT_INTSIDENDIS ON OBJEKT_INTSIDENDIS\n" +
            "(\n" +
            "       objekt_intsidendis_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF51OBJEKT_INTSIDENDIS ON OBJEKT_INTSIDENDIS\n" +
            "(\n" +
            "       objekt_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF52OBJEKT_INTSIDENDIS ON OBJEKT_INTSIDENDIS\n" +
            "(\n" +
            "       intsident_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE PIIRIRIKKUJA (\n" +
            "       piiririkkuja_ID      INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       isikukood            VARCHAR(20),\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       eesnimi              VARCHAR(25),\n" +
            "       perek_nimi           VARCHAR(35),\n" +
            "       sugu                 CHAR(1),\n" +
            "       synniaeg             DATE,\n" +
            "       objekt_ID            INTEGER NOT NULL,\n" +
            "       PRIMARY KEY (piiririkkuja_ID), \n" +
            "       FOREIGN KEY (objekt_ID)\n" +
            "                             REFERENCES OBJEKT\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKPIIRIRIKKUJA ON PIIRIRIKKUJA\n" +
            "(\n" +
            "       piiririkkuja_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF59PIIRIRIKKUJA ON PIIRIRIKKUJA\n" +
            "(\n" +
            "       objekt_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE ISIK_INTSIDENDIS (\n" +
            "       isik_intsidendis_ID  INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       alates               DATE NOT NULL,\n" +
            "       kuni                 DATE NOT NULL,\n" +
            "       kirjeldus            LONGVARCHAR NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       intsident_ID         INTEGER NOT NULL,\n" +
            "       piiririkkuja_ID      INTEGER NOT NULL,\n" +
            "       PRIMARY KEY (isik_intsidendis_ID), \n" +
            "       FOREIGN KEY (piiririkkuja_ID)\n" +
            "                             REFERENCES PIIRIRIKKUJA\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (intsident_ID)\n" +
            "                             REFERENCES INTSIDENT\n" +
            "                             ON DELETE SET NULL\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKISIK_INTSIDENDIS ON ISIK_INTSIDENDIS\n" +
            "(\n" +
            "       isik_intsidendis_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF53ISIK_INTSIDENDIS ON ISIK_INTSIDENDIS\n" +
            "(\n" +
            "       intsident_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF54ISIK_INTSIDENDIS ON ISIK_INTSIDENDIS\n" +
            "(\n" +
            "       piiririkkuja_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE RIIK (\n" +
            "       riik_ID              INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       ISO_kood             VARCHAR(20) NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       ANSI_kood            CHAR(18),\n" +
            "       PRIMARY KEY (riik_ID)\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKRIIK ON RIIK\n" +
            "(\n" +
            "       riik_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE ISIKU_SEADUS_INTSIDENDIS (\n" +
            "       isiku_seadus_intsidendis_ID INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       alates               DATE NOT NULL,\n" +
            "       kuni                 DATE NOT NULL,\n" +
            "       kirjeldus            LONGVARCHAR NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       isik_intsidendis_ID  INTEGER NOT NULL,\n" +
            "       seaduse_punkt_ID     INTEGER NOT NULL,\n" +
            "       PRIMARY KEY (isiku_seadus_intsidendis_ID), \n" +
            "       FOREIGN KEY (seaduse_punkt_ID)\n" +
            "                             REFERENCES SEADUSE_PUNKT\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (isik_intsidendis_ID)\n" +
            "                             REFERENCES ISIK_INTSIDENDIS\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKISIKU_SEADUS_INTSIDENDIS ON ISIKU_SEADUS_INTSIDENDIS\n" +
            "(\n" +
            "       isiku_seadus_intsidendis_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF63ISIKU_SEADUS_INTSIDENDIS ON ISIKU_SEADUS_INTSIDENDIS\n" +
            "(\n" +
            "       isik_intsidendis_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF64ISIKU_SEADUS_INTSIDENDIS ON ISIKU_SEADUS_INTSIDENDIS\n" +
            "(\n" +
            "       seaduse_punkt_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE OBJEKTI_SEADUS_INTSIDENDIS (\n" +
            "       objekti_seadus_intsidendis_ID INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       alates               DATE NOT NULL,\n" +
            "       kuni                 DATE NOT NULL,\n" +
            "       kirjeldus            LONGVARCHAR NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       objekt_intsidendis_ID INTEGER NOT NULL,\n" +
            "       seaduse_punkt_ID     INTEGER NOT NULL,\n" +
            "       PRIMARY KEY (objekti_seadus_intsidendis_ID), \n" +
            "       FOREIGN KEY (seaduse_punkt_ID)\n" +
            "                             REFERENCES SEADUSE_PUNKT\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (objekt_intsidendis_ID)\n" +
            "                             REFERENCES OBJEKT_INTSIDENDIS\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKOBJEKTI_SEADUS_INTSIDENDIS ON OBJEKTI_SEADUS_INTSIDENDIS\n" +
            "(\n" +
            "       objekti_seadus_intsidendis_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF65OBJEKTI_SEADUS_INTSIDENDI ON OBJEKTI_SEADUS_INTSIDENDIS\n" +
            "(\n" +
            "       objekt_intsidendis_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF66OBJEKTI_SEADUS_INTSIDENDI ON OBJEKTI_SEADUS_INTSIDENDIS\n" +
            "(\n" +
            "       seaduse_punkt_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE KODAKONDSUS (\n" +
            "       kodakondsus_ID       INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       alates               DATE,\n" +
            "       kuni                 DATE,\n" +
            "       riik_ID              INTEGER NOT NULL,\n" +
            "       piiririkkuja_ID      INTEGER NOT NULL,\n" +
            "       isikukood            VARCHAR(20),\n" +
            "       PRIMARY KEY (kodakondsus_ID), \n" +
            "       FOREIGN KEY (piiririkkuja_ID)\n" +
            "                             REFERENCES PIIRIRIKKUJA\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (riik_ID)\n" +
            "                             REFERENCES RIIK\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKKODAKONDSUS ON KODAKONDSUS\n" +
            "(\n" +
            "       kodakondsus_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF67KODAKONDSUS ON KODAKONDSUS\n" +
            "(\n" +
            "       riik_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF68KODAKONDSUS ON KODAKONDSUS\n" +
            "(\n" +
            "       piiririkkuja_ID\n" +
            ");\n" +
            "\n" +
            "\n" +
            "CREATE TABLE PIIRIVALVURI_SEADUS_INTSIDENDI (\n" +
            "       piirivalvuri_seadus_intsidendi INTEGER,\n" +
            "       avaja                VARCHAR(32) NOT NULL,\n" +
            "       avatud               DATE NOT NULL,\n" +
            "       muutja               VARCHAR(32) NOT NULL,\n" +
            "       muudetud             DATE NOT NULL,\n" +
            "       sulgeja              VARCHAR(32),\n" +
            "       suletud              DATE NOT NULL,\n" +
            "       alates               DATE NOT NULL,\n" +
            "       kuni                 DATE NOT NULL,\n" +
            "       kirjeldus            LONGVARCHAR NOT NULL,\n" +
            "       kommentaar           LONGVARCHAR,\n" +
            "       piirivalvur_intsidendis_ID INTEGER NOT NULL,\n" +
            "       seaduse_punkt_ID     INTEGER NOT NULL,\n" +
            "       PRIMARY KEY (piirivalvuri_seadus_intsidendi), \n" +
            "       FOREIGN KEY (seaduse_punkt_ID)\n" +
            "                             REFERENCES SEADUSE_PUNKT\n" +
            "                             ON DELETE RESTRICT, \n" +
            "       FOREIGN KEY (piirivalvur_intsidendis_ID)\n" +
            "                             REFERENCES PiIRIVALVUR_INTSIDENDIS\n" +
            "                             ON DELETE RESTRICT\n" +
            ");\n" +
            "\n" +
            "CREATE UNIQUE INDEX XPKPIIRIVALVURI_SEADUS_INTSIDE ON PIIRIVALVURI_SEADUS_INTSIDENDI\n" +
            "(\n" +
            "       piirivalvuri_seadus_intsidendi\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF69PIIRIVALVURI_SEADUS_INTSI ON PIIRIVALVURI_SEADUS_INTSIDENDI\n" +
            "(\n" +
            "       piirivalvur_intsidendis_ID\n" +
            ");\n" +
            "\n" +
            "CREATE INDEX XIF70PIIRIVALVURI_SEADUS_INTSI ON PIIRIVALVURI_SEADUS_INTSIDENDI\n" +
            "(\n" +
            "       seaduse_punkt_ID\n" +
            ");" +
            "CREATE SEQUENCE PIIRIRIKKUJA_SEQ AS INTEGER START WITH 1 INCREMENT BY 1;" +
            "CREATE SEQUENCE hibernate_sequence AS INTEGER START WITH 1 INCREMENT BY 1;";

}
