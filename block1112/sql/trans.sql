SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `trans`;
CREATE TABLE `trans`
(
    `transId` int(11) NOT NULL ,
    `block_id`       int(11) NOT NULL,
    `txHash`       char (64) NOT NULL,
    `amount`        double,
    `total_input`        double,
    `total_output`      double,
    `time`        bigint(20),
    `confirmations`        int(11),
    `status`        int(11),
    `weight`        int(11),
    `fee`        double,
    `fee_per_weight`        double,
    `fee_per_byte`        double,
    `sizeOndisk`        int(11),
    PRIMARY KEY (`transId`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8
  auto_increment = 1;
