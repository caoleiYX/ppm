-- ----------------------------
-- Table structure for demo
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
    `id` varchar(32) COLLATE utf8_bin NOT NULL,
    `id_key` varchar(128) COLLATE utf8_bin NOT NULL,
    `name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
    `sort_id` int(11) DEFAULT NULL,
    `create_time` datetime DEFAULT NULL COMMENT '创建时间',
    `update_time` datetime DEFAULT NULL COMMENT '修改时间',
    `app_name` varchar(128) COLLATE utf8_bin DEFAULT NULL COMMENT '租户',
    `tenant_id` varchar(32) COLLATE utf8_bin DEFAULT NULL,
    `mapping_id` bigint(32) NOT NULL UNIQUE COMMENT '数字串映射id',
    `del_flag` smallint(6) DEFAULT NULL COMMENT '删除标记（0：正常；1：删除；2：审核)',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=DYNAMIC;
