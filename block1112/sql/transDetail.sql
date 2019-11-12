SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for question
-- ----------------------------
DROP TABLE IF EXISTS `transDetail`;
CREATE TABLE `transDetail`
(
    `tx_detail_id`  bigint(20) NOT NULL,
    `transId`      int(11) NOT NULL,
    `address`         varchar (50),
    `amount`   double ,
    `type`  tinyint (11),

    PRIMARY KEY (`tx_detail_id`)

) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 auto_increment=1;
