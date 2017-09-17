DROP TABLE IF EXISTS companies;
CREATE TABLE companies (
  id      SERIAL,
  logo_id INTEGER               DEFAULT NULL,
  title   VARCHAR(300) NOT NULL DEFAULT '',
  url     VARCHAR(200) NOT NULL DEFAULT '',
  index   INTEGER      NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  UNIQUE (title, url),
  FOREIGN KEY (logo_id) REFERENCES files (id)
);

INSERT INTO companies VALUES
  (1, 22, 'Ecoteh', 'http://ecoteh.com.ua', 1),
  (2, 23, 'Go-It', 'https://goit.ua', 2),
  (3, 24, 'Prog.kiev.ua', 'https://prog.kiev.ua', 3),
  (4, 26, 'Taras Shevchenko National University of Kyiv', 'http://www.univ.kiev.ua/en/', 4),
  (5, 29, 'Sololearn', 'https://www.sololearn.com', 5);


DROP TABLE IF EXISTS contacts;
CREATE TABLE contacts (
  id        SERIAL,
  phone     VARCHAR(100) NOT NULL DEFAULT '',
  email     VARCHAR(100) NOT NULL DEFAULT '',
  vkontakte VARCHAR(200) NOT NULL DEFAULT '',
  facebook  VARCHAR(200) NOT NULL DEFAULT '',
  twitter   VARCHAR(200) NOT NULL DEFAULT '',
  linkedin  VARCHAR(200) NOT NULL DEFAULT '',
  github    VARCHAR(200) NOT NULL DEFAULT '',
  skype     VARCHAR(100) NOT NULL DEFAULT '',
  index     INTEGER      NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);

INSERT INTO contacts VALUES
  (1, '+38 (063) 160-01-18', 'yuriy.alex.salimov@gmail.com', 'https://vk.com/yurii.salimov',
   'https://www.facebook.com/yurii.alex.salimov', '',
   'https://ua.linkedin.com/in/yurii-salimov', 'https://github.com/YuriiSalimov',
   'yurii.salimov', 1);


DROP TABLE IF EXISTS educations;
CREATE TABLE educations (
  id             SERIAL,
  experience_id  INTEGER      NOT NULL,
  certificate_id INTEGER      NOT NULL,
  title          VARCHAR(300) NOT NULL DEFAULT '',
  index          INTEGER      NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  FOREIGN KEY (experience_id) REFERENCES experiences (id),
  FOREIGN KEY (certificate_id) REFERENCES files (id)
);

INSERT INTO educations VALUES
  (1, 3, 25, 'Java OOP and Java Pro', 1),
  (2, 4, 27, 'Bachelor of physics, Photonics, Faculty of Physics', 3),
  (3, 5, 28, 'Master of physics, Photonics, Faculty of Physics', 2),
  (4, 6, 30, 'Java Tutorial course', 4),
  (5, 7, 31, 'SQL Fundamentals course', 5),
  (6, 8, 32, 'CSS Fundamentals course', 6),
  (7, 9, 33, 'HTML Fundamentals course', 7);


DROP TABLE IF EXISTS experiences;
CREATE TABLE experiences (
  id          SERIAL,
  company_id  INTEGER      NOT NULL,
  position    VARCHAR(300) NOT NULL DEFAULT '',
  start_month INTEGER      NOT NULL DEFAULT 0,
  start_year  INTEGER      NOT NULL DEFAULT 0,
  end_month   INTEGER      NOT NULL DEFAULT 0,
  end_year    INTEGER      NOT NULL DEFAULT 0,
  is_now      BOOLEAN      NOT NULL DEFAULT TRUE,
  index       INTEGER      NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  FOREIGN KEY (company_id) REFERENCES companies (id)
);

INSERT INTO experiences VALUES
  (1, 1, 'Java Web Developer', 9, 2016, 0, 0, TRUE, 1),
  (2, 2, 'Menthor, Java', 1, 2017, 0, 0, TRUE, 2),
  (3, 3, 'Student', 1, 2016, 6, 2016, TRUE, 3),
  (4, 4, 'Student', 9, 2010, 6, 2014, TRUE, 4),
  (5, 4, 'Student', 9, 2014, 6, 2016, TRUE, 5),
  (6, 5, 'Student', 1, 2017, 2, 2017, TRUE, 6),
  (7, 5, 'Student', 2, 2017, 2, 2017, TRUE, 7),
  (8, 5, 'Student', 3, 2017, 3, 2017, TRUE, 8),
  (9, 5, 'Student', 3, 2017, 3, 2017, TRUE, 9);

CREATE TYPE FILE_TYPE AS ENUM ('LOGO', 'BANNER', 'SLIDE', 'CERTIFICATE', 'OTHER');
DROP TABLE IF EXISTS files;
CREATE TABLE files (
  id    SERIAL,
  title VARCHAR(100) NOT NULL DEFAULT '',
  url   VARCHAR(200) NOT NULL DEFAULT '',
  type  FILE_TYPE    NOT NULL DEFAULT 'OTHER',
  index INTEGER      NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);

INSERT INTO files VALUES
  (1, 'Yurii Salimov', '/resources/img/about.jpg', 'LOGO', 1),
  (2, 'Alex Coffee', '/resources/img/alexcoffee.jpg', 'LOGO', 2),
  (3, 'Alex Coffee, banner', '/resources/img/alexcoffee_banner.jpg', 'BANNER', 3),
  (4, 'Ricki Vs Marti', '/resources/img/RickiVsMarti.jpg', 'LOGO', 4),
  (5, 'Ricki Vs Marti, banner', '/resources/img/RickiVsMarti_banner.png', 'BANNER', 5),
  (6, '15 puzzle', '/resources/img/15puzzle.jpg', 'LOGO', 6),
  (7, '15 puzzle, banner', '/resources/img/15puzzle_banner.jpg', 'BANNER', 7),
  (8, 'Slide 0', '/resources/img/slide_0.jpg', 'SLIDE', 8),
  (9, 'Slide 1', '/resources/img/slide_1.jpg', 'SLIDE', 9),
  (10, 'Slide 2', '/resources/img/slide_2.jpg', 'SLIDE', 10),
  (11, 'Slide 3', '/resources/img/slide_3.jpg', 'SLIDE', 11),
  (12, 'Slide 4', '/resources/img/slide_4.jpg', 'SLIDE', 12),
  (13, 'Slide 5', '/resources/img/slide_5.jpg', 'SLIDE', 13),
  (14, 'Slide 6', '/resources/img/slide_6.jpg', 'SLIDE', 14),
  (15, 'Slide 7', '/resources/img/slide_7.jpg', 'SLIDE', 15),
  (16, 'Slide 8', '/resources/img/slide_8.jpg', 'SLIDE', 16),
  (17, 'Slide 9', '/resources/img/slide_9.jpg', 'SLIDE', 17),
  (18, 'Slide 10', '/resources/img/slide_10.jpg', 'SLIDE', 18),
  (19, 'Slide 11', '/resources/img/slide_11.jpg', 'SLIDE', 19),
  (22, 'Ecoteh', '/resources/img/ecoteh_logo.png', 'LOGO', 20),
  (23, 'Go-It', '/resources/img/goit_logo.png', 'LOGO', 21),
  (24, 'Prog.kiev.ua', '/resources/img/prog.kiev.ua_logo.png', 'LOGO', 22),
  (25, 'Prog.kiev.ua, certificate', '/resources/img/prog.kiev.ua_certificate.png', 'CERTIFICATE', 23),
  (26, 'KNU, logo', '/resources/img/knu_logo.png', 'LOGO', 24),
  (27, 'KNU, bachelor certificate', '/resources/img/bachelor_diploma.pdf', 'CERTIFICATE', 25),
  (28, 'KNU, master certificate', '/resources/img/master_diploma.pdf', 'CERTIFICATE', 26),
  (29, 'Sololearn, logo', '/resources/img/sololearn_logo.png', 'LOGO', 27),
  (30, 'Sololearn, java tutorial course certificate', '/resources/img/sololearn_java_tutorial_course.pdf',
   'CERTIFICATE', 28),
  (31, 'Sololearn, sololearn sql fundamentals course certificate',
   '/resources/img/sololearn_sql_fundamentals_course.pdf', 'CERTIFICATE', 29),
  (32, 'Sololearn, sololearn CSS fundamentals course certificate',
   '/resources/img/sololearn_css_fundamentals_course.pdf', 'CERTIFICATE', 30),
  (33, 'Sololearn, sololearn HTML fundamentals course certificate',
   '/resources/img/sololearn_html_fundamentals_course.pdf', 'CERTIFICATE', 31),
  (34, 'Default File', '/resources/img/default_file.gif', 'BANNER', 33);


DROP TABLE IF EXISTS information;
CREATE TABLE information (
  id          SERIAL,
  logo_id     INTEGER               DEFAULT NULL,
  slide_id    INTEGER               DEFAULT NULL,
  title       VARCHAR(100) NOT NULL DEFAULT '',
  description TEXT         NOT NULL,
  text        TEXT         NOT NULL,
  keywords    TEXT         NOT NULL,
  position    VARCHAR(200) NOT NULL DEFAULT '',
  index       INTEGER      NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  FOREIGN KEY (logo_id) REFERENCES files (id),
  FOREIGN KEY (slide_id) REFERENCES files (id)
);

INSERT INTO information VALUES
  (1, 1, 1, 'Yurii Salimov', 'Java Web Developer', '', 'Yurii Salimov, Java Web Developer, J2EE',
   'Java Web Developer', 1),
  (2, 32, 32, 'Android Game', 'Android Game', 'Android Game', 'Android Game', 'Android Developer', 2),
  (3, 32, 32, 'Web Sites', 'Web Sites', 'Web Sites', 'Web Sites', 'Java Web Developer', 3),
  (4, 4, 5, 'Ricki vs Marti', 'Logic puzzle game',
   '<p style=\"text-align:justify\"><img alt=\"\" src=\"/resources/img/RickiVsMarti_logo.png\" style=\"float:left; height:70px; margin:5px 10px; width:70px\" />Logic puzzle game. The game &quot;Ricki vs Marti&quot; is played on a game board. Clicking on any cell changes it. Also, all cells in the same row and column as the pressing cell change their value to the opposite. So the dog will appear in place of the cat and the cat will appear in place of the dog. The aim of the game is to fill the entire field with the same animals, it is desirable to making as little as possible moves.</p>\r\n\r\n<p style=\"text-align:center\"><a href=\"/resources/img/RickiVsMarti_slide_1.jpg\" rel=\"lightgallery[slides]\" title=\"Ricki vs Marti\"><img alt=\"\" src=\"/resources/img/RickiVsMarti_slide_1.jpg\" style=\"height:400px; margin:5px 10px; width:225px\" title=\"Ricki vs Marti\" /></a><a href=\"/resources/img/RickiVsMarti_slide_2.jpg\" rel=\"lightgallery[slides]\" title=\"Ricki vs Marti\"><img alt=\"\" src=\"/resources/img/RickiVsMarti_slide_2.jpg\" style=\"height:400px; margin:5px 10px; width:225px\" title=\"Ricki vs Marti\" /></a><a href=\"/resources/img/RickiVsMarti_slide_2.jpg\" rel=\"lightgallery[slides]\" title=\"Ricki vs Marti\"><img alt=\"\" src=\"/resources/img/RickiVsMarti_slide_3.jpg\" style=\"height:400px; margin:5px 10px; width:225px\" title=\"Ricki vs Marti\" /></a></p>\r\n',
   'Ricki vs Marti, Android game, Logic puzzle game', 'Full Stack Developer', 4),
  (5, 6, 7, '15 puzzle', 'Logic puzzle game',
   '<p style=\"text-align:justify\"><img alt=\"\" src=\"/resources/img/15puzzle_logo.png\" style=\"float:left; height:70px; margin:5px 10px; width:70px\" /><a href=\"/resources/img/15puzzle_slide_1.jpg\" rel=\"lightgallery[slides]\" title=\"15 puzzle\"><img alt=\"\" src=\"/resources/img/15puzzle_slide_1.jpg\" style=\"float:right; height:300px; margin:5px 10px; width:169px\" title=\"15 puzzle\" /></a>The <a href=\"https://en.wikipedia.org/wiki/15_puzzle\" target=\"_blank\"><strong>15-puzzle</strong></a> (also called Gem Puzzle, Boss Puzzle, Game of Fifteen, Mystic Square and many others) is a sliding puzzle that consists of a frame of indexed square tiles in random order with one tile missing. The puzzle also exists in other sizes, particularly the smaller 8-puzzle. If the size is 3&times;3 tiles, the puzzle is called the 8-puzzle or 9-puzzle, and if 4&times;4 tiles, the puzzle is called the 15-puzzle or 16-puzzle named, respectively, for the index of tiles and the index of spaces. The object of the puzzle is to place the tiles in order by making sliding moves that use the empty space.</p>\r\n\r\n<p style=\"text-align:justify\">The puzzle was &quot;invented&quot; by Noyes Palmer Chapman,&nbsp;a postmaster in&nbsp;Canastota, New York, who is said to have shown friends, as early as 1874, a precursor puzzle consisting of 16 indexed blocks that were to be put together in rows of four,&nbsp;each summing to 34. Copies of the improved Fifteen Puzzle made their way to&nbsp;Syracuse, New York, by way of Noyes&#39; son, Frank, and from there, via sundry connections, <a href=\"/resources/img/15puzzle_slide_3.jpg\" rel=\"lightgallery[slides]\" title=\"15 puzzle\"><img alt=\"\" src=\"/resources/img/15puzzle_slide_3.jpg\" style=\"float:left; height:300px; margin:5px 10px; width:169px\" title=\"15 puzzle\" /></a>to&nbsp;Watch Hill, RI, and finally to&nbsp;Hartford&nbsp;(Connecticut), where students in the&nbsp;American School for the Deaf&nbsp;started manufacturing the puzzle and, by December 1879, selling them both locally and in&nbsp;Boston, Massachusetts. Shown one of these, Matthias Rice, who ran a fancy woodworking business in Boston, started manufacturing the puzzle sometime in December 1879 and convinced a &quot;Yankee Notions&quot; fancy goods dealer to sell them under the name of &quot;Gem Puzzle&quot;. In late January 1880, Dr. Charles Pevey, a dentist in&nbsp;Worcester, Massachusetts, garnered some attention by offering a cash reward for a solution to the Fifteen Puzzle.</p>\r\n\r\n<p style=\"text-align:justify\">The game became a craze in the&nbsp;U.S.&nbsp;in February 1880,&nbsp;Canada&nbsp;in March,&nbsp;Europe&nbsp;in April, but that craze had pretty much dissipated by July. Apparently the puzzle was not introduced to&nbsp;Japan&nbsp;until 1889.</p>\r\n\r\n<p style=\"text-align:justify\">Noyes Chapman had applied for a patent on his &quot;Block Solitaire Puzzle&quot; on February 21, 1880. However, that patent was rejected, likely because it was not sufficiently different from the August 20, 1878 &quot;Puzzle-Blocks&quot; patent (US 207124) granted to Ernest U. Kinsey.<a href=\"/resources/img/15puzzle_slide_2.jpg\" rel=\"lightgallery[slides]\" title=\"15 puzzle\"><img alt=\"\" src=\"/resources/img/15puzzle_slide_2.jpg\" style=\"float:right; height:1px; margin:0px; width:1px\" title=\"15 puzzle\" /></a></p>\r\n',
   '15 puzzle, Android game, Logic puzzle game', 'Full Stack Developer', 5),
  (6, 2, 3, 'Alex Coffee', 'Website of coffee',
   '<p style=\"text-align:justify\"><a href=\"http://alexcoffee.com.ua\" target=\"_blank\" title=\"Alex Coffee\"><img alt=\"\" src=\"/resources/img/alexcoffee_logo.png\" style=\"height:81px; margin:5px 10px; width:360px\" title=\"Alex Coffee\" /></a></p>\r\n\r\n<p style=\"text-align:justify\">&quot;Alex Coffee&quot; is the online shop of a beautiful and aromatic coffee for You and friends. Here You can buy coffee beans, ground coffee, coffee in mono doses and in capsules. Coffee is a drink of the real programmer. :-)</p>\r\n\r\n<p style=\"text-align:justify\"><em><strong>Used Technologies</strong></em>: Java EE, Maven, Servlets, Spring Framework (IoC, MVC, Data, Security), JPA / Hibernate, MySQL, JSP / JSTL, Bootstrap, CSS, JS, Junit, Mockito, Jacoco.</p>\r\n\r\n<p style=\"text-align:justify\">Shop work can be divided into 3 parts: for clients, for administrator and for managers.</p>\r\n\r\n<p style=\"text-align:justify\"><strong>For clients</strong></p>\r\n\r\n<p style=\"text-align:justify\">Clients can only navigate on the main pages of the website, view products and make orders.</p>\r\n\r\n<p style=\"text-align:center\"><a href=\"/resources/img/alexcoffee_categories.jpg\" rel=\"lightgallery[slides]\" title=\"Categories | Alex Coffee\"><img alt=\"Categories\" src=\"/resources/img/alexcoffee_categories.jpg\" style=\"height:178px; margin:5px 10px; width:400px\" title=\"Categories | Alex Coffee\" /></a><a href=\"/resources/img/alexcoffee_product.jpg\" rel=\"lightgallery[slides]\" title=\"Product | Alex Coffee\"><img alt=\"\" src=\"/resources/img/alexcoffee_product.jpg\" style=\"height:193px; margin:5px 10px; width:400px\" title=\"Product | Alex Coffee\" /></a></p>\r\n\r\n<p style=\"text-align:justify\"><strong>For Managers</strong></p>\r\n\r\n<p style=\"text-align:justify\">Managers can navigate on the main pages of the site and the pages intended for managers (.../manager). Managers have the access to edit information about the orders after consultation with the customer, view information about the site personnel to enable communication with colleagues.</p>\r\n\r\n<p style=\"text-align:center\"><a href=\"/resources/img/alexcoffee_manager_orders.jpg\" rel=\"lightgallery[slides]\" title=\"Manager orders | Alex Coffee\"><img alt=\"\" src=\"/resources/img/alexcoffee_manager_orders.jpg\" style=\"height:132px; margin:5px 10px; width:400px\" title=\"Manager orders | Alex Coffee\" /></a><a href=\"/resources/img/alexcoffee_manager_edit_order.jpg\" title=\"Manager order | Alex Coffee\"><img alt=\"\" src=\"/resources/img/alexcoffee_manager_edit_order.jpg\" style=\"height:196px; margin:5px 10px; width:400px\" title=\"Manager order | Alex Coffee\" /></a></p>\r\n\r\n<p style=\"text-align:justify\"><strong>For Administrator</strong></p>\r\n\r\n<p style=\"text-align:justify\">Administrator can navigate on all the pages of the site, in particular through the pages of managers and pages intended for the administrator (.../admin). Administrator can add, edit, and delete information about the products, categories and managers. All information is stored in the database.</p>\r\n\r\n<p style=\"text-align:center\"><a href=\"/resources/img/alexcoffee_admin_orders.jpg\" rel=\"lightgallery[slides]\" title=\"Admin orders | Alex Coffee\"><img alt=\"\" src=\"/resources/img/alexcoffee_admin_orders.jpg\" style=\"height:193px; margin:5px 10px; width:400px\" title=\"Admin orders | Alex Coffee\" /></a><a href=\"/resources/img/alexcoffee_admin_product.jpg\" title=\"Product | Alex Coffee\"><img alt=\"\" src=\"/resources/img/alexcoffee_admin_product.jpg\" style=\"height:221px; margin:5px 10px; width:400px\" title=\"Product | Alex Coffee\" /></a></p>\r\n\r\n<p style=\"text-align:justify\">To access the pages of managers and administrators need to be authorized (.../login). Without the authorization of access is denied. After ordering by client, managers receive a message on e-mail with order details and client contact information.</p>\r\n',
   'AlexCoffee, Alex Coffee, online shop, Yurii Salimov, Java Web Developer, J2EE',
   'Full Stack Developer', 6);


DROP TABLE IF EXISTS jobs;
CREATE TABLE jobs (
  id            SERIAL,
  experience_id INTEGER          DEFAULT NULL,
  index         INTEGER NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);

INSERT INTO jobs VALUES
  (1, 1, 1),
  (2, 2, 2);

CREATE TYPE LANGUAGE_LEVEL AS ENUM ('ELEMENTARY', 'UPPER_ELEMENTARY', 'PRE_INTERMEDIATE', 'INTERMEDIATE', 'UPPER_INTERMEDIATE', 'ADVANCED', 'PROFICIENCY');
DROP TABLE IF EXISTS languages;
CREATE TABLE languages (
  id    SERIAL,
  name  VARCHAR(100)   NOT NULL DEFAULT '',
  level LANGUAGE_LEVEL NOT NULL DEFAULT 'ELEMENTARY',
  index INTEGER        NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);

INSERT INTO languages VALUES
  (1, 'Ukrainian', 'PROFICIENCY', 1),
  (2, 'Russian', 'PROFICIENCY', 2),
  (3, 'English', 'PRE_INTERMEDIATE', 3);


DROP TABLE IF EXISTS projects;
CREATE TABLE projects (
  id             SERIAL,
  information_id INTEGER               DEFAULT NULL,
  url            VARCHAR(200) NOT NULL DEFAULT '',
  source         VARCHAR(300) NOT NULL DEFAULT '',
  link           VARCHAR(300) NOT NULL DEFAULT '',
  index          INTEGER      NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  UNIQUE (url),
  FOREIGN KEY (information_id) REFERENCES information (id)
);

INSERT INTO projects VALUES
  (1, 4, 'rickivsmarti', 'https://github.com/YuriiSalimov/RickiVsMartin',
   'https://play.google.com/store/apps/details?id=com.mr_alex.rickivsmartin', 1),
  (2, 5, '15puzzle', 'https://github.com/YuriiSalimov/15puzzle',
   'https://play.google.com/store/apps/details?id=com.mr_alex.pyatnashki', 2),
  (3, 6, 'alex_coffee', 'https://github.com/YuriiSalimov/AlexCoffee', 'http://alexcoffee.com.ua', 3);


DROP TABLE IF EXISTS skills;
CREATE TABLE skills (
  id    SERIAL,
  title VARCHAR(100) NOT NULL DEFAULT '',
  index INTEGER      NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);

INSERT INTO skills VALUES
  (1, 'OOP Basics', 1),
  (2, 'IO, Multithreading', 2),
  (3, 'Generics, Collections', 3),
  (4, 'XML, DOM, JAXB, JSON', 4),
  (5, 'Servlets, JSP, JSTL', 5),
  (6, 'MySQL, JPA, Hibernate', 6),
  (7, 'Spring IoC, MVC, Data, Security', 7),
  (8, 'Patterns (Iterator, Singleton et al.)', 8),
  (9, 'Junit, Mockito, Jacoco', 9),
  (10, 'Maven', 10),
  (11, 'Tomcat', 11),
  (12, 'IDE: IntelliJ IDEA, NetBeans', 12),
  (13, 'Fundamental: HTML, CSS, Unix', 13);

CREATE TYPE USER_ROLE AS ENUM ('ADMIN', 'USER', 'ANONYMOUS');
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  id             SERIAL,
  information_id INTEGER               DEFAULT NULL,
  contacts_id    INTEGER               DEFAULT NULL,
  login          VARCHAR(300) NOT NULL DEFAULT '',
  password       VARCHAR(300) NOT NULL DEFAULT '',
  city           VARCHAR(100) NOT NULL DEFAULT '',
  role           USER_ROLE    NOT NULL DEFAULT 'ANONYMOUS',
  url            VARCHAR(200) NOT NULL DEFAULT '',
  index          INTEGER      NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  UNIQUE (url, login, password),
  FOREIGN KEY (information_id) REFERENCES information (id),
  FOREIGN KEY (contacts_id) REFERENCES contacts (id)
);

INSERT INTO users VALUES
  (1, 1, 1, 'Login', 'Password', 'Kyiv', 'ADMIN', 'yuriisalimov', 1);


DROP TABLE IF EXISTS users_courses;
CREATE TABLE users_courses (
  user_id   INTEGER NOT NULL,
  course_id INTEGER NOT NULL,
  PRIMARY KEY (user_id, course_id),
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (course_id) REFERENCES educations (id)
);

INSERT INTO users_courses VALUES
  (1, 1),
  (1, 4),
  (1, 5),
  (1, 6),
  (1, 7);


DROP TABLE IF EXISTS users_educations;
CREATE TABLE users_educations (
  user_id      INTEGER NOT NULL,
  education_id INTEGER NOT NULL,
  PRIMARY KEY (user_id, education_id),
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (education_id) REFERENCES educations (id)
);

INSERT INTO users_educations VALUES
  (1, 2),
  (1, 3);


DROP TABLE IF EXISTS users_experiences;
CREATE TABLE users_experiences (
  user_id       INTEGER NOT NULL,
  experience_id INTEGER NOT NULL,
  PRIMARY KEY (user_id, experience_id),
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (experience_id) REFERENCES experiences (id)
);

INSERT INTO users_experiences VALUES
  (1, 1),
  (1, 2);


DROP TABLE IF EXISTS users_languages;
CREATE TABLE users_languages (
  user_id     INTEGER NOT NULL,
  language_id INTEGER NOT NULL,
  PRIMARY KEY (user_id, language_id),
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (language_id) REFERENCES languages (id)
);

INSERT INTO users_languages VALUES
  (1, 1),
  (1, 2),
  (1, 3);


DROP TABLE IF EXISTS users_skills;
CREATE TABLE users_skills (
  user_id  INTEGER NOT NULL,
  skill_id INTEGER NOT NULL,
  PRIMARY KEY (user_id, skill_id),
  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (skill_id) REFERENCES skills (id)
);

INSERT INTO users_skills VALUES
  (1, 1),
  (1, 2),
  (1, 3),
  (1, 4),
  (1, 5),
  (1, 6),
  (1, 7),
  (1, 8),
  (1, 9),
  (1, 10),
  (1, 11),
  (1, 12),
  (1, 13);
