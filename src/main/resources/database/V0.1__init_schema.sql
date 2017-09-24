DROP TYPE IF EXISTS FILE_TYPE;
CREATE TYPE FILE_TYPE AS ENUM ('LOGO', 'BANNER', 'SLIDE', 'CERTIFICATE', 'PHOTO', 'OTHER');

DROP TABLE IF EXISTS files;
CREATE TABLE files (
  id       SERIAL,
  name     VARCHAR(20),
  path     VARCHAR(50) NOT NULL UNIQUE,
  type     FILE_TYPE   NOT NULL DEFAULT 'OTHER',
  group_id INTEGER UNIQUE,
  index    INTEGER     NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS information;
CREATE TABLE information (
  id           SERIAL      NOT NULL,
  first_name   VARCHAR(15) NOT NULL,
  second_name  VARCHAR(15) NOT NULL,
  description  TEXT,
  dob          DATE,
  phone_number VARCHAR(20) UNIQUE,
  email        VARCHAR(25) UNIQUE,
  github       VARCHAR(50),
  skype        VARCHAR(30),
  linkedin     VARCHAR(50),
  vk           VARCHAR(50),
  photo        INTEGER,
  files        INTEGER,
  PRIMARY KEY (id),
  FOREIGN KEY (photo) REFERENCES files (id),
  FOREIGN KEY (files) REFERENCES files (group_id)
);

DROP TYPE IF EXISTS PROJECT_STATUS;
CREATE TYPE PROJECT_STATUS AS ENUM ('PLANNING', 'DEVELOPING', 'IMPLEMENTED');

DROP TABLE IF EXISTS projects;
CREATE TABLE projects (
  id          SERIAL         NOT NULL,
  name        VARCHAR(50)    NOT NULL,
  description TEXT,
  status      PROJECT_STATUS NOT NULL DEFAULT 'IMPLEMENTED',
  keywords    TEXT,
  source      VARCHAR(50),
  link        VARCHAR(50),
  logo        INTEGER,
  files       INTEGER,
  index       INTEGER        NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  FOREIGN KEY (logo) REFERENCES files (id),
  FOREIGN KEY (files) REFERENCES files (group_id)
);

DROP TYPE IF EXISTS EDUCATION_STATUS;
CREATE TYPE EDUCATION_STATUS AS ENUM ('PLANNING', 'STUDYING', 'COMPLETED');

DROP TABLE IF EXISTS education;
CREATE TABLE education (
  id          SERIAL           NOT NULL,
  name        VARCHAR(50)      NOT NULL,
  description TEXT,
  status      EDUCATION_STATUS NOT NULL DEFAULT 'COMPLETED',
  start_date  DATE,
  end_date    DATE,
  logo        INTEGER,
  files       INTEGER,
  index       INTEGER          NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  FOREIGN KEY (logo) REFERENCES files (id),
  FOREIGN KEY (files) REFERENCES files (group_id)
);

DROP TYPE IF EXISTS WORK_STATUS;
CREATE TYPE WORK_STATUS AS ENUM ('PLANNING', 'WORKING', 'FINISHED');

DROP TABLE IF EXISTS work;
CREATE TABLE work (
  id          SERIAL      NOT NULL,
  name        VARCHAR(50) NOT NULL,
  description TEXT,
  status      WORK_STATUS NOT NULL DEFAULT 'FINISHED',
  position    VARCHAR(50),
  start_date  DATE,
  end_date    DATE,
  link        VARCHAR(50),
  logo        INTEGER,
  files       INTEGER,
  index       INTEGER     NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  FOREIGN KEY (logo) REFERENCES files (id),
  FOREIGN KEY (files) REFERENCES files (group_id)
);

DROP TYPE IF EXISTS LANGUAGE_LEVEL;
CREATE TYPE LANGUAGE_LEVEL AS ENUM ('ELEMENTARY', 'UPPER_ELEMENTARY', 'PRE_INTERMEDIATE', 'INTERMEDIATE', 'UPPER_INTERMEDIATE', 'ADVANCED', 'PROFICIENCY');

DROP TABLE IF EXISTS languages;
CREATE TABLE languages (
  id    SERIAL,
  name  VARCHAR(20)    NOT NULL,
  level LANGUAGE_LEVEL NOT NULL DEFAULT 'ELEMENTARY',
  index INTEGER        NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS skills;
CREATE TABLE skills (
  id    SERIAL,
  name  VARCHAR(20) NOT NULL,
  logo  INTEGER,
  index INTEGER     NOT NULL DEFAULT 0,
  PRIMARY KEY (id)
);

DROP TABLE IF EXISTS contests;
CREATE TABLE contests (
  id          SERIAL      NOT NULL,
  name        VARCHAR(50) NOT NULL,
  description TEXT,
  link        VARCHAR(50),
  logo        INTEGER,
  files       INTEGER,
  index       INTEGER     NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  FOREIGN KEY (logo) REFERENCES files (id),
  FOREIGN KEY (files) REFERENCES files (group_id)
);

DROP TYPE IF EXISTS SCIENTIFIC_WORK_STATUS;
CREATE TYPE SCIENTIFIC_WORK_STATUS AS ENUM ('PLANNING', 'WORKING', 'COMPLETED');

DROP TABLE IF EXISTS scientific_works;
CREATE TABLE scientific_works (
  id          SERIAL                 NOT NULL,
  name        VARCHAR(50)            NOT NULL,
  description TEXT,
  link        VARCHAR(50),
  status      SCIENTIFIC_WORK_STATUS NOT NULL DEFAULT 'COMPLETED',
  files       INTEGER,
  index       INTEGER                NOT NULL DEFAULT 0,
  PRIMARY KEY (id),
  FOREIGN KEY (files) REFERENCES files (group_id)
);