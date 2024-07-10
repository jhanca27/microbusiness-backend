-- MariaDB dump 10.17  Distrib 10.4.6-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: ubuntudb
-- ------------------------------------------------------
-- Server version	10.4.6-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `countries` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` VALUES (1,'Colombia'),(2,'Argentina'),(3,'Chile');
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `micro_businesses`
--

DROP TABLE IF EXISTS `micro_businesses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `micro_businesses` (
  `deleted` tinyint(1) DEFAULT 0,
  `managed` tinyint(1) DEFAULT 0,
  `country_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `province_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `more_information` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `sub_title` varchar(255) DEFAULT NULL,
  `category` enum('AGROECOLOGY','COMPANIES_IMPACT','CONSERVATION','SOCIAL_ECONOMY') NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKncj5mjjf3xtx78mle9jp1y2r7` (`country_id`),
  KEY `FK4q1vk89tnp4su6hvoelp8w71x` (`province_id`),
  KEY `FKh8mhfpjtwthp36rkw98ql7s4k` (`user_id`),
  CONSTRAINT `FK4q1vk89tnp4su6hvoelp8w71x` FOREIGN KEY (`province_id`) REFERENCES `provinces` (`id`),
  CONSTRAINT `FKh8mhfpjtwthp36rkw98ql7s4k` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FKncj5mjjf3xtx78mle9jp1y2r7` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `micro_businesses`
--

LOCK TABLES `micro_businesses` WRITE;
/*!40000 ALTER TABLE `micro_businesses` DISABLE KEYS */;
INSERT INTO `micro_businesses` VALUES (0,0,NULL,1,1,1,'Sustainable environmental solutions','Offering eco-friendly products and services','Pioneers in Eco-Friendly Solutions','EcoGreen Solutions','SOCIAL_ECONOMY'),(0,0,NULL,2,2,2,'Innovative agricultural practices','Promoting organic farming techniques','Leaders in Organic Farming','AgroHarvest Co.','AGROECOLOGY'),(0,0,NULL,3,3,3,'Protecting natural habitats','Programs for wildlife conservation','Champions of Wildlife Conservation','ConserveNature','CONSERVATION'),(0,0,NULL,4,4,4,'Business solutions for social good','Consulting for sustainable development','Advancing Social Impact through Business','Impact Innovators','COMPANIES_IMPACT'),(0,0,NULL,5,5,5,'Urban gardening and farming','Workshops and supplies for urban agriculture','Empowering Urban Gardeners','GreenThumb Gardens','SOCIAL_ECONOMY'),(0,0,NULL,6,6,6,'Eco-friendly farming solutions','Supporting local farmers with green technology','Innovators in Green Farming Technology','BioFarm Enterprises','AGROECOLOGY'),(0,0,NULL,7,7,7,'Wildlife protection initiatives','Education and advocacy for endangered species','Protectors of Endangered Species','Wildlife Warriors','CONSERVATION'),(0,0,NULL,8,8,8,'Future-proof business practices','Consulting for long-term sustainability','Experts in Sustainable Business Practices','Sustainable Futures','COMPANIES_IMPACT'),(0,0,NULL,9,9,9,'Environmental care and awareness','Campaigns to increase environmental consciousness','Promoting Environmental Awareness','Nature Nurturers','SOCIAL_ECONOMY'),(0,0,NULL,10,10,10,'Advanced agricultural techniques','Promoting sustainable farming methods','Pioneers in Sustainable Agriculture','EcoFarm Solutions','AGROECOLOGY');
/*!40000 ALTER TABLE `micro_businesses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provinces`
--

DROP TABLE IF EXISTS `provinces`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `provinces` (
  `country_id` bigint(20) DEFAULT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK48p9qkti5auert2gquvn76338` (`country_id`),
  CONSTRAINT `FK48p9qkti5auert2gquvn76338` FOREIGN KEY (`country_id`) REFERENCES `countries` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provinces`
--

LOCK TABLES `provinces` WRITE;
/*!40000 ALTER TABLE `provinces` DISABLE KEYS */;
INSERT INTO `provinces` VALUES (1,1,'Amazonas'),(1,2,'Antioquia'),(1,3,'Arauca'),(1,4,'Atlántico'),(1,5,'BolÃ­var'),(1,6,'BoyacÃ¡'),(1,7,'Caldas'),(1,8,'CaquetÃ¡'),(1,9,'Casanare'),(1,10,'Cauca'),(1,11,'Cesar'),(1,12,'ChocÃ³'),(1,13,'CÃ³rdoba'),(1,14,'Cundinamarca'),(1,15,'GuainÃ­a'),(1,16,'Guaviare'),(1,17,'Huila'),(1,18,'La Guajira'),(1,19,'Magdalena'),(1,20,'Meta'),(1,21,'NariÃ±o'),(1,22,'Norte de Santander'),(1,23,'Putumayo'),(1,24,'QuindÃ­o'),(1,25,'Risaralda'),(1,26,'San AndrÃ©s y Providencia'),(1,27,'Santander'),(1,28,'Sucre'),(1,29,'Tolima'),(1,30,'Valle del Cauca'),(1,31,'VaupÃ©s'),(1,32,'Vichada'),(2,33,'Buenos Aires'),(2,34,'Catamarca'),(2,35,'Chaco'),(2,36,'Chubut'),(2,37,'CÃ³rdova'),(2,38,'Corrientes'),(2,39,'Entre RÃ­os'),(2,40,'Formosa'),(2,41,'Jujuy'),(2,42,'La Pampa'),(2,43,'La Rioja'),(2,44,'Mendoza'),(2,45,'Misiones'),(2,46,'NeuquÃ©n'),(2,47,'RÃ­o Negro'),(2,48,'Salta'),(2,49,'San Juan'),(2,50,'San Luis'),(2,51,'Santa Cruz'),(2,52,'Santa Fe'),(2,53,'Santiago del Estero'),(2,54,'Tierra del Fuego, AntÃ¡rtida e Islas del AtlÃ¡ntico Sur'),(2,55,'TucumÃ¡n'),(3,56,'Arica'),(3,57,'Parinacota'),(3,58,'Iquique'),(3,59,'Tamarugal'),(3,60,'Tocopilla'),(3,61,'El Loa'),(3,62,'Antofagasta'),(3,63,'ChaÃ±aral'),(3,64,'CopiapÃ³'),(3,65,'Huasco'),(3,66,'Elqui'),(3,67,'LimarÃ­'),(3,68,'Choapa'),(3,69,'Petorca'),(3,70,'Los Andes'),(3,71,'San Felipe de Aconcagua'),(3,72,'Quillota'),(3,73,'ValparaÃ­so'),(3,74,'San Antonio'),(3,75,'Isla de Pascua'),(3,76,'Marga Marga'),(3,77,'Chacabuco'),(3,78,'Santiago'),(3,79,'Cordillera'),(3,80,'Maipo'),(3,81,'Melipilla'),(3,82,'Talagante'),(3,83,'Cachapoal'),(3,84,'Colchagua'),(3,85,'Caro'),(3,86,'CuricÃ³'),(3,87,'Talca'),(3,88,'Linares'),(3,89,'Cauquenes'),(3,90,'DiguillÃ­n'),(3,91,'Itata'),(3,92,'Punilla'),(3,93,'BiobÃ­o'),(3,94,'ConcepciÃ³n'),(3,95,'Arauco'),(3,96,'Malleco'),(3,97,'CautÃ­n'),(3,98,'Valdivia'),(3,99,'Ranco'),(3,100,'Osorno'),(3,101,'Llanquihue'),(3,102,'ChiloÃ©'),(3,103,'Palena'),(3,104,'Coyhaique'),(3,105,'AysÃ©n'),(3,106,'General Carrera'),(3,107,'CapitÃ¡n Prat'),(3,108,'Ãšltima Esperanza'),(3,109,'Magallanes'),(3,110,'Tierra del Fuego'),(3,111,'AntÃ¡rtica Chilena');
/*!40000 ALTER TABLE `provinces` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `deleted` tinyint(1) DEFAULT 0,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `first_name` varchar(255) NOT NULL,
  `last_name` varchar(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `role` varchar(10) DEFAULT 'admin',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (0,1,'jhan@gmail.com','Jhan','Ca','32516136513','admin'),(0,2,'alice.smith@example.com','Alice','Smith','1234567890','admin'),(0,3,'bob.johnson@example.com','Bob','Johnson','0987654321','admin'),(0,4,'charlie.brown@example.com','Charlie','Brown','1112223333','admin'),(0,5,'diana.davis@example.com','Diana','Davis','4445556666','admin'),(0,6,'eve.miller@example.com','Eve','Miller','7778889999','admin'),(0,7,'frank.wilson@example.com','Frank','Wilson','3332221111','admin'),(0,8,'grace.moore@example.com','Grace','Moore','6665554444','admin'),(0,9,'hank.taylor@example.com','Hank','Taylor','9998887777','admin'),(0,10,'ivy.anderson@example.com','Ivy','Anderson','2223334445','admin');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-10 18:22:51
