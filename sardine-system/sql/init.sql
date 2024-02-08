create table user
(
    user_id              bigint       not null comment 'id'
        primary key,
    user_code            varchar(128) not null comment '用户编码',
    username             varchar(32)  not null comment '用户名称',
    email                varchar(64)  null comment '邮箱',
    phone_number         varchar(16)  null comment '手机号',
    last_login_time      timestamp    null comment '最后登录时间',
    last_login_ip        timestamp    null comment '最后登录ip',
    create_time          timestamp    not null comment '创建时间',
    create_user_id       bigint       not null comment '创建人id',
    create_username      varchar(32)  not null comment '创建人名称',
    last_modify_time     timestamp    not null comment '最后修改时间',
    last_modify_user_id  bigint       not null comment '最后修改人id',
    last_modify_username varchar(32)  not null comment '最后修改人名称',
    deleted              tinyint(1)   not null comment '是否删除',
    version              bigint       not null comment '版本号',
    constraint user_code_pk
        unique (user_code),
    constraint user_email_pk
        unique (email),
    constraint user_phone_number_pk
        unique (phone_number)
)
    comment '用户表';

