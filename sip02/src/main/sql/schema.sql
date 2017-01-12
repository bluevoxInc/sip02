drop table if exists contact;
create table contact (
    id bigserial primary key,
    last_name varchar(40) not null,
    first_name varchar(40) not null,
    mi char(1),
    email varchar(80),
    date_created timestamp with time zone DEFAULT now(),
    date_modified timestamp with time zone DEFAULT now()
);

CREATE unique index contact_idx1 on contact (last_name, first_name, mi);
    



  

