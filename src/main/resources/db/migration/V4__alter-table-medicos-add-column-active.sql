alter table medicos add active tinyint not null;

update medicos set active = 1;