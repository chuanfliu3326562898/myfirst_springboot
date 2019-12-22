CREATE TABLE `channel` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `is_del` int(11) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `display_name` varchar(16) NOT NULL DEFAULT '' COMMENT '外显名称',
  `note_name` varchar(20) NOT NULL DEFAULT '' COMMENT '备注名称',
  `is_handpick` int(11) NOT NULL DEFAULT '0' COMMENT '是否精选',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=495 DEFAULT CHARSET=utf8mb4 COMMENT='频道';