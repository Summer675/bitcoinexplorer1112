SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for knowledge
-- ----------------------------
DROP TABLE IF EXISTS `block`;
CREATE TABLE `block`
(
    `height` int(11) NOT NULL ,
    `block_id`        int (11),
    `block_hash`        char (64),
    `mined`           varchar (50)  ,
    `size`        int (11),
    `time`      bigint(20),
    `confirmations`        int(11),
    `difficulty`        double,
    `bits`           int (11),
    `weight`        int (11),
    `markle_root`      char(64),
    `nonce`           varchar (50)  ,
    `version`        varchar (50),
    `txSize`      int (11),,
    `sizeOndisk`        int(11),
    `feereword`        double ,
    `blockreword`          double ,
    `transactionVolume`        double
    PRIMARY KEY (`block_id`),

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  auto_increment = 1;
