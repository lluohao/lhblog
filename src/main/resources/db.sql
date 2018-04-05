 CREATE TABLE `blog` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `md` mediumtext,
  `html` mediumtext,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `count` int(11) DEFAULT '0',
  `type` int(11) NOT NULL,
  `status` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `typedef` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(20) NOT NULL UNIQUE,
  PRIMARY KEY(tid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;