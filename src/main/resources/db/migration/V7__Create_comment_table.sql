create table comment
(
    id BIGINT auto_increment,
    parent_id bigint not null,
    type int not null,
    commentator int not null,
    gmt_create BIGINT not null,
    gmt_modified bigint not null,
    like_count BIGINT default 0,
    constraint TABLE_NAME_PK
        primary key (id)
);