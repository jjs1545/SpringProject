-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: localhost    Database: brm
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `blog`
--

DROP TABLE IF EXISTS `blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `blog` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `USERS_NO` int(11) DEFAULT NULL,
  `TITLE` varchar(100) DEFAULT NULL,
  `LOGO` varchar(255) DEFAULT 'name.jpg',
  PRIMARY KEY (`no`),
  KEY `USERS_NO` (`USERS_NO`),
  CONSTRAINT `blog_ibfk_1` FOREIGN KEY (`USERS_NO`) REFERENCES `member` (`no`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog`
--

LOCK TABLES `blog` WRITE;
/*!40000 ALTER TABLE `blog` DISABLE KEYS */;
INSERT INTO `blog` VALUES (1,1,'주신의 블로그','1532604792.jpg'),(2,2,'이윤열','name.jpg'),(3,3,'류동환','name.jpg'),(4,4,'보끄라운 히덩이~>__<','1532593032.jpg'),(5,5,'티티','1532594238.jpg'),(6,6,'큐더블류이','name.jpg'),(7,7,'정주신','name.jpg');
/*!40000 ALTER TABLE `blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `BLOG_NO` int(11) DEFAULT NULL,
  `NAME` varchar(30) DEFAULT NULL,
  `POST_COUNT` int(11) DEFAULT '0',
  `DESCRIPTION` varchar(20) DEFAULT NULL,
  `REG_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`no`),
  KEY `BLOG_NO` (`BLOG_NO`),
  CONSTRAINT `category_ibfk_1` FOREIGN KEY (`BLOG_NO`) REFERENCES `blog` (`no`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,1,'미분류',2,'미분류 카테고리','2018-07-26 16:20:29'),(2,1,'스타크래프트',1,'게임','2018-07-26 16:21:07'),(3,1,'축구',4,'취미','2018-07-26 16:21:13'),(4,1,'여행',6,'여행','2018-07-26 16:21:18'),(6,2,'미분류',0,'미분류 카테고리','2018-07-26 17:14:29'),(7,3,'미분류',0,'미분류 카테고리','2018-07-26 17:14:56'),(9,4,'오늘은 몇요일',2,'오늘 몇일인지 세는 ..ㅋ','2018-07-26 17:18:59'),(10,4,'S2',0,'><','2018-07-26 17:19:43'),(13,1,'새카테고리',0,'추가했습니다','2018-07-26 20:33:31'),(14,7,'미분류',0,'미분류 카테고리','2018-07-26 20:49:11');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `comment` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `POST_NO` int(11) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `CONTENT` varchar(555) DEFAULT NULL,
  `REG_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`no`),
  KEY `POST_NO` (`POST_NO`),
  CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`POST_NO`) REFERENCES `post` (`no`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,11,'정주신','헐','2018-07-26 16:57:21'),(2,11,'정주신','페이징','2018-07-26 16:57:27'),(3,13,'히정이','gdgd','2018-07-26 17:19:57'),(4,13,'히정이','예소리 멍통이 ㅎㅎ','2018-07-26 17:20:41'),(7,15,'정주신','좋은 정보 감사합니다.','2018-07-26 19:16:20'),(8,15,'이윤열','잘보고 갑니다','2018-07-26 19:16:41'),(9,15,'류동환','좋은 정보네요','2018-07-26 19:17:10'),(10,15,'정주신','잘보고 갑니다','2018-07-26 20:15:55');
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `member` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `id` varchar(128) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `join_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`no`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'js','정주신','123','2018-07-26 16:20:29'),(2,'nada','이윤열','123','2018-07-26 17:14:29'),(3,'ryu','류동환','123','2018-07-26 17:14:56'),(4,'HeeJung','히정이','123','2018-07-26 17:16:07'),(5,'tt','티티','123','2018-07-26 17:34:33'),(6,'qwe','큐더블류이','123','2018-07-26 19:32:39'),(7,'nuda','정주신','123','2018-07-26 20:49:10');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `post` (
  `no` int(11) NOT NULL AUTO_INCREMENT,
  `CATEGORY_NO` int(11) DEFAULT NULL,
  `TITLE` varchar(100) DEFAULT NULL,
  `CONTENT` varchar(1500) DEFAULT NULL,
  `REG_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`no`),
  KEY `CATEGORY_NO` (`CATEGORY_NO`),
  CONSTRAINT `post_ibfk_1` FOREIGN KEY (`CATEGORY_NO`) REFERENCES `category` (`no`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,1,'네이버 블로그','포털사이트 네이버에서 운영하는 국내 최대의 서비스형 블로그. 2003년 6월, \'페이퍼\'라는 서비스를 오픈한 게 시초이며, 같은 해 10월 12일에 블로그라는 이름으로 정식 서비스를 시작해 현재까지 내려오고 있다. 언론 보도에 따르면 2009년 6월 기준으로 활동 블로거 숫자가 약 1800만 명에 달한다고 하며, 2016년 4월 네이버 블로그팀의 공식 발표로는 2300만 개의 블로그가 개설되어 있다고 한다. 참고로 블로그차트 순위에 존재하는 블로그는 약 1400만 개이며, 이들 중 3분의 2 정도가 네이버 블로그다.\r\n\r\n강화된 보안을 위해 https가 적용된다.','2018-07-26 16:20:58'),(2,2,'김택용','대한민국의 前 스타크래프트, 스타크래프트 2 프로게이머.\r\n\r\n신예 시절부터 독보적인 실력으로 주목을 받았으며, 브루드 워 양대 개인 리그( MBC GAME 스타리그와 온게임넷 스타리그 ) 총합 3회 우승을 기록한 유일한 프로토스, MSL에서의 프로토스 최후의 우승자, 유일한 프로토스 3회,2연속 우승자 등의 기록으로 커리어 또한 뛰어나 많은 팬들의 관심을 받는 인기 게이머이다.\r\n\r\n양대 개인 리그 7회 연속 예선 통과에 성공하면서 양대 개인 리그 최다 연속 예선 통과 기록을 보유하고 있으며[20]. 김택용의 메이저 데뷔는 2006년이기 때문에 박성준의 기록보다는 포스가 떨어지는 것이 사실. 그러나 김택용은 그가 데뷔한 신한은행 스타리그 2006 시즌 2, 곰TV MSL 시즌1 이후 본선 진출에 실패한 대회가 신한은행 스타리그 2006 시즌 3 단 한 번밖에 없었다. 17번의 대회 중 16번을 진출한 것은 분명 엄청난 기록이다. 1번의 탈락도 3.3 혁명이 일어나기 전인 신인 시절이다.[21] 하지만 진에어 스타리그 2011 오프 라인 예선 4강에서 탈락하면서 기록이 종료되었다. 그 외에 다른 기록들은 하단의 진 기록 / 명 기록 문서 참조.\r\n\r\n2007년 3월 3일 본좌의 시대를 종결시키면서 모든 스타 팬의 머릿속에 자신의 이름 석 자를 각인시킨 이 게이머는 그 이후로도 꾸준히 프로리그와 개인리그에서 활약하였다. 특히나 프로토스의 저그전 극복 역사에서 그의 이름은 뺄래야 뺄 수가 없다. 그 후 시작된 택뱅리쌍의 시대에서도 다른 강자들과 함께 불꽃 튀는 승부를 보이며 스타판을 흥분으로 달구는 정상급 플레이어로서 그 위치를 단단히 지켰다.\r\n\r\n허나 개인 리그의 성적 저하로 시작된 부진이 스 2 전환 후, 전체적인 실력 저하로 나타나면서 김택용은 점점 잊혀져 갔다. 그럼에도 프로리그에 간간히 1승이라도 거두어 주면서 분전했지만 결국 격차를 따라잡기는 힘들었는지 2013년 9월 9일에 은퇴를 발표하였다. 김택용의 은퇴 직전 마찬가지로 은퇴를 선언한 허영무와는 달리 기량이 상당히 떨어져 있는 상태였기 때문에 은퇴를 납득하는 팬들도 많았으나 그래도 택뱅리쌍의 한 축을 이루던, 한 시대를 풍미했던 선수였기에 은퇴에 대한 파장은 허영무 못지 않았다.','2018-07-26 16:21:54'),(3,2,'단장의 능선','Map size: 128x96\r\nMap tile: Jungle\r\nPlayers: 2\r\n단장의 능선 문서의 1번 항목을 테마로 하고 제목도 따온 스타크래프트 맵. 신한은행 프로리그 08-09 4라운드에서 처음으로 등장했다. 제목에 나오는 능선이 맵에 고루 펼쳐져 있는 것을 상징화했다. 신한은행 프로리그 09-10 2라운드부터 신 단장의 능선으로 버전업되어 사용되었다. 온게임넷 EVER 스타리그 2009에서는 8강부터 신 단장의 능선으로 교체 사용되었다.\r\n\r\n신한은행 프로리그 08-09 1/2/3라운드(위너스 리그)에서 쓰인 추풍령과 흡사한 부분이 많으나, 추풍령이 구릉지형을 위주로 한 난전맵과는 다르게 맵 전체적으로 복합적으로 난전이 펼쳐지도록 설계된 것이 추풍령과 다른 점이다.\r\n\r\n테징징의 능선이라고 할 정도로 정말 몇 없는 테란 압살맵이다. 특히 프로토스 상대로는 정말 어렵기 그지없다. 그럼에도 이영호 때문에 맵 전적은 의외로 비등비등하다. 이 맵을 끼고도 이영호는 EVER 스타리그 2009에서 우승을 차지했다.\r\n\r\n정확히는 저그맵이다. 멀티 다수의 좁은 길목에 러커 배치, 뒷길, 오버로드 띄워놓을 데가 넘쳐나고 은근히 3센티 드랍을 사용하기도 좋으며 앞마당 뮤짤이 편한 데다가, 안정적인 4가스, 긴 지상 러시 거리와 그다지 멀지않은 공중상의 거리[1] 등등. 특히 초반에 포지 더블넥의 심시티가 체계화되지 않아서 토스가 저그에게 많이 털렸다.\r\n\r\n능선은 테란이 자리잡거나 하는 것 이외에는 별 전략적 요소가 없다. 결국 신 단장의 능선이 나왔는데 앞마당에 미네랄 1개를 더 깔은 것과 센터에 변화를 주었다.\r\n\r\n묘하게 김택용과 상성이 매우 안 좋다.(…) 하단 항목 참고. 그래서 코파는 능선이라 부르기도 한다. 실제로 김택용은 이 맵에서의 전적이 13승 4패로 매우 좋은 편이고 여기서 환상적인 드라군 컨트롤[2]로 이영호를 이긴 적도 있었으나, 진 경기들에서 워낙 임팩트있게 패했기에 이런 이미지가 각인되고 말았다. 대표적으로 콩진호가 735일만에 승리를 거둔 6.20대첩의 희생자가 바로 코택용이다.','2018-07-26 16:22:19'),(4,2,'이제동','한국의 前 스타크래프트, 스타크래프트 2 프로게이머. \r\n\r\n화승 OZ의 에이스. 온게임넷 스타리그 저그 4대(EVER 2007), 6대(바투), 7대(박카스 2009) 우승자[20]이자 2번째 리버스 스윕, 2번째 프로리그 100승, 임요환, 허영무와 더불어 스타리그를 2번째로 2회 연속 우승한 선수. 저그의 2번째 골든 마우스 등등 2라는 숫자와 인연이 있다.\r\n\r\n잘 다루는 유닛은 저글링과 뮤탈리스크[21]로, 타 선수를 압도하는 센스와 컨트롤 덕에 그의 시합은 보통 레어 테크에서 끝나는 경우가 많다. 그래서 한때는 레어본좌라고 불리며 레어 단계에서의 몰아치기로 상대를 뭉개버리는 플레이를 자주 선보여 별명이 폭군, 파괴신, 이제동네-이다. 2010년을 기준으로 폭군이라는 명칭이 거의 정식 별명이 되었다.','2018-07-26 16:22:38'),(5,3,'Arsenal','\"병기창\", \"무기고\", \"조선소\",라는 의미. 국립국어원 표준 표기법에 의하면 정확한 표기는 아스널이다.\r\n\r\n','2018-07-26 16:23:03'),(6,3,'리버풀 FC','그(샹클리)는 온몸을 붉은색으로 물들이는 게 상대에게 위압감을 가져다줄 것이라 생각했다. 어느 날 그는 드레싱 룸으로 들어와서 로니 예이츠에게 빨간색 하의 한 벌을 건네더니, \"이거 한 번 입어봐라. 어떤지 좀 보자.\" 라고 했다. 로니가 빨간 바지를 건네 받고 챙겨 입자 그는 \"오, 로니, 장난 아니게 멋진데? 놀라워. 키가 2미터는 돼 보이네.\"라고 했다. 그 모습을 본 내가 제안하길, \"아예 양말도 빨간색으로 해 버리죠? 모두 빨간색으로 하고 나가요.\" 샹클리는 찬성했고, 그것이 리버풀의 새로운 상징이 탄생하는 순간이었다.\"\r\n\r\n- 이안 세인트 존.[11] 그의 자서전에서.','2018-07-26 16:23:22'),(7,4,'우루과이','남아메리카에 위치한 나라로 정식 명칭은 \'우루과이 동방 공화국(República Oriental del Uruguay)\'. 인구는 2005년 기준 346만 명이며 이들 중의 절반이 수도 몬테비데오에 거주한다. 면적은 17만 6200㎢으로, 남한의 1.7배 정도 되는 크기니까 그렇게 작은 크기는 아닌데 이웃의 두 나라가 하나같이 스케일이 크고, 다른 나라들도 국토 면적이 크다 보니 우루과이가 작아 보인다. 인구 수가 적은 것도 한 몫 하는 모양이다. 남미에서는 수리남 다음으로 작은 나라.\r\n\r\n세계적인 축산국이다. \r\n\r\n수도는 몬테비데오. 공용어로는 스페인어를 사용한다. 우리에게는 김영삼 前 대통령 집권 초기에 체결된 \'우루과이 라운드\'라는 쌀 개방 협정으로 잘 알려진 국가.\r\n\r\n남아메리카 국가 가운데서 가장 1인당 국민소득이 높은나라이며 단순히 1인당 GDP가 높을뿐만 아니라 정치도 깨끗한 편에[2] 치안과 복지수준도 괜찮아서 OECD에 가입되어있지 않지만 남아메리카 국가 가운데서 가장 선진적인 국가로 손꼽힌다. 임금 수준은 아르헨티나에 밀리지만 브라질이나 멕시코에 비해서는 괜찮은 편이다.\r\n\r\n브라질과는 한때 같은 나라였고, 지금도 매우 가깝지만 느낌이 확 달라진다. 덥고 너저분하고 위험한 브라질과 달리 이쪽은 시원하고 깔끔하며 안전하다!!! 우루과이인들은 브라질 하면 덥고 벌레 많고 비위생적이고 위험한 동네로 인식하는 경향이 있다. \r\n\r\n이웃 아르헨티나와 더불어 백인이 주류인 보기 드문 남미 국가다. 원래부터 원주민의 인구가 많지 않아서 식민지 개척 이후 격렬한 저항에도 지속적으로 내륙으로 밀려난 데다가 1831년 초대 대통령의 조카가 차루아 부족원들을 초대해놓고서 이들을 학살한 사건으로 결정타를 맞았다.[3] 그나마 20세기 들어서 원주민들의 문화를 복원하려는 노력들이 이어지고 있지만, 이미 때 늦은 일이다. 우루과이 총 인구 가운데서 원주민 조상을 가지고 있는 인구는 3% 내외 정도의 수준이다.','2018-07-26 16:23:38'),(8,4,'브라질','남아메리카 동반부에 위치하는 국가. 남아메리카와 남반구에서 가장 넓은 나라다. 수도는 브라질리아(Brasilia).[4] 브라질리아 연방구와 26개의 주로 구성된 연방국가다. 유명한 것은 지구의 허파라 불리는 아마존 밀림, 정열적이기로 소문이 자자한 삼바춤과 삼바 축제, 그리고 축구. 국가는 브라질 국가(Hino Nacional Brasileiro)이다.\r\n\r\n1인당 GDP는 아직 높지는 않으나 워낙 인구가 많고 면적이 크고 자원이 풍부하다보니 GDP 순위는 8위이다. 네이버 GDP IMF\r\n\r\nIMF 투표권은 10위다. https://en.wikipedia.org/wiki/International_Monetary_Fund\r\n\r\n미국과 비슷한 점이 많다. 같은 대륙에 있는 국가들을 압도하는 국력[5], 넓은 영토와 방대한 인구, 다민족국가라라는 점 그리고 대도시들의 영 좋지 못한 치안등에서 비슷한 점이 많다.','2018-07-26 16:23:50'),(9,4,'스페인','스페인(Spain)이란 이름은 영어식 표기이며 스페인어로는 España라고 적고, 에스빠냐라고 발음[6]한다. 실제로는 에스파냐라고 적는데, 이는 외래어 표기법에 따른 것으로, 스페인어의 P 발음은 ㅍ보다는 ㅃ에 가깝지만 외래어 표기법은 실제로 된소리와 예사소리의 구분이 없는 언어에 대해서는 된소리가 나도 된소리로 적지 않는 것이 원칙이다. 고대 로마 시대에 이베리아 반도를 히스파니아(Hispania)라고 불렀는데 스페인과 에스파냐 모두 여기서 유래했다. 한자 가차로는 \'에스파냐\'를 음역하여 서반아(西班牙)라고 쓴다. 히스파니아는 페니키아어(고전 히브리어)로 \'토끼의 땅(אי-שפניא, i-shfania)\'에서 따온 말인 것으로 보이는데, 토끼가 많아서 이런 이름이 붙었다고 한다.\r\n\r\n우리나라의 경우 미국의 영향을 받아 영어식 표기인 스페인이 일찍 정착하였으나 1980년대 이후 원어에 가깝게 표현하기 위해 교과서 등지에서 에스파냐라는 표기를 사용하기 시작하였고, 1988 서울 올림픽 개막식에서도 한글 국가명으로 에스파냐를 사용하여 가나다 순으로 앙골라, 에콰도르와 입장하였다. 그러나 글자 수가 더 적고 발음이 더 쉬운 스페인에 밀려 정착에 실패하였고, 현재는 한국의 대 스페인 외교 관련 문서에서 공식적으로 스페인으로 지칭하는 것은 물론, 한국 주재 대사관에서조차 \'주한 스페인 대사관\'을 공식적으로 사용할 정도이다. 2018 평창 동계올림픽에서 스페인으로 입장하였다.\r\n\r\n아무튼 에스파냐라고 부르는 사람들이 가끔씩 있고, 알아듣는 사람도 제법 된다.','2018-07-26 16:49:35'),(10,4,'하위','하위','2018-07-26 16:53:03'),(11,4,'스페인','스페인(Spain)이란 이름은 영어식 표기이며 스페인어로는 España라고 적고, 에스빠냐라고 발음[6]한다. 실제로는 에스파냐라고 적는데, 이는 외래어 표기법에 따른 것으로, 스페인어의 P 발음은 ㅍ보다는 ㅃ에 가깝지만 외래어 표기법은 실제로 된소리와 예사소리의 구분이 없는 언어에 대해서는 된소리가 나도 된소리로 적지 않는 것이 원칙이다. 고대 로마 시대에 이베리아 반도를 히스파니아(Hispania)라고 불렀는데 스페인과 에스파냐 모두 여기서 유래했다. 한자 가차로는 \'에스파냐\'를 음역하여 서반아(西班牙)라고 쓴다. 히스파니아는 페니키아어(고전 히브리어)로 \'토끼의 땅(אי-שפניא, i-shfania)\'에서 따온 말인 것으로 보이는데, 토끼가 많아서 이런 이름이 붙었다고 한다.\r\n\r\n우리나라의 경우 미국의 영향을 받아 영어식 표기인 스페인이 일찍 정착하였으나 1980년대 이후 원어에 가깝게 표현하기 위해 교과서 등지에서 에스파냐라는 표기를 사용하기 시작하였고, 1988 서울 올림픽 개막식에서도 한글 국가명으로 에스파냐를 사용하여 가나다 순으로 앙골라, 에콰도르와 입장하였다. 그러나 글자 수가 더 적고 발음이 더 쉬운 스페인에 밀려 정착에 실패하였고, 현재는 한국의 대 스페인 외교 관련 문서에서 공식적으로 스페인으로 지칭하는 것은 물론, 한국 주재 대사관에서조차 \'주한 스페인 대사관\'을 공식적으로 사용할 정도이다. 2018 평창 동계올림픽에서 스페인으로 입장하였다.\r\n\r\n아무튼 에스파냐라고 부르는 사람들이 가끔씩 있고, 알아듣는 사람도 제법 된다.','2018-07-26 16:56:15'),(12,3,'아스날','도라, 서로는 포르투갈, 남으로는 모로코 왕국 및 지브롤터와 인접하고있다. 수도는 마드리드(Madrid). 국토면적은 50만 6,000km2, 인구는 2017년도 기준으로 4,600만 명[4]정도이다. \r\n\r\n전 근대 시기에 프랑스나 독일, 이탈리아에 비해서 특별히 인구가 많은 편이 아니었던데다가, 스페인이 북아메리카, 중앙아메리카 및 브라질을 뺀 남아메리카와 카리브 해 일대의 여러 섬, 필리핀, 괌, 북마리아나 제도 등을 식민지로 삼으면서 많은 인구가 라틴아메리카 일대와 미국, 필리핀 등지로 빠져나갔다. 그나마 인구유출이 광범위하게 벌어진 것에 비해서는 현재의 인구가 꽤나 상당한 편으로, 출산율은 1970년대까지도 상당한 편이라 그동안 인구가 유출된 것에 비해서는 인구가 크게 늘어나기는 했고, 1980년대 이후로 출산율이 급감했지만 당시 경제적으로 영 상태가 좋지 않던 라틴 아메리카와 중동권으로부터 많은 인구가 몰려와서 인구가 이나마 늘어났다.[5] 인구 밀도도 92명(2011)으로 낮은 편이나, 유로존에서 5번째 경','2018-07-26 17:13:32'),(13,9,'월요일 죠아~~','난 일할때 제일 멋지지 ♬','2018-07-26 17:19:28'),(14,1,'ㅎㅇ','ㅎㅇ','2018-07-26 17:25:01'),(15,4,'프랑스','대서양과 지중해에 맞닿은 유럽의 본토와 대양에 산재한 여러 국외 영토로 구성된 국가.\r\n\r\n영국, 독일, 러시아와 함께 유럽 4대 강대국 중 하나이며, 유럽 제3의 경제 대국이다. 경제 순위는 영국과 매년 엎치락 뒤치락 한다. 왕정 시절에는 비옥하고 광활한 영토에서 비롯된 생산력과 인구를 바탕으로 프랑크 왕국 때는 동로마 제국과 더불어 유럽 투톱 취급 받았고, 분열 이후 프랑스 왕국 시절에는 신성 로마 제국과 더불어 서유럽 투톱 취급을 받았고, 영국이 18세기부터 대두한 후에는 영국과 세계 각지에서 겨루며 투톱 취급을 받았다. 아닌 게 아니라 프랑스의 인구는 중세 시대부터 1,600만으로 서유럽에서 가장 많았고[11] 16세기에는 2,000만에 달했다. 17~18세기에는 2,000만을 넘어 2,400만에 육박했으며, 프랑스 제1공화국 때는 2,800만, 프랑스의 최전정기인 프랑스 제1제국 때는 3,100만[12]에 달하여 서유럽 최대의 인구대국이었다. 이를 뛰어넘은 유럽 나라는 오로지 제정 러시아 뿐이었다.[13] 그러나 남들은 20세기 후반에 들어와 겪을 저출산 문제를 19세기부터 경험한 탓에(...)[14], 오늘날에는 인구에서 독일에 밀린다. \r\n\r\n유럽-대서양-북해-지중해의 중심에 있는 지정학적 위치를 가지고 있고, 인접한 주변 나라들이 영국, 스페인, 독일, 이탈리아, 스위스, 네덜란드, 벨기에 등 서유럽 네임드 국가들이 많다 보니 다양한 문화를 받아들이는 한편 전파도 하는 등 문화적 영향력이 크다. 아예 프랑스가 제국주의 정책을 취했던 19세기에는 프랑스 문화가 전세계로 뻗어나갔기 때문에 20세기 이전 세계 문화와 예술의 중심지라 할 수 있었다.\r\n\r\n영국, 미국과 함께 시민 혁명의 발상지이자 근대 민주주의의 발상지로도 유명하다.','2018-07-26 19:16:03');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-07-27  9:18:56
