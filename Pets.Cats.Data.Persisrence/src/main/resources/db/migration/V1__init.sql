/*
    Cat table
*/
create table if not exists cats_db.public.cats
(
    id         uuid not null
        primary key,
    name       text not null,
    color      text,
    breed      text,
    owner_id   uuid references owners on delete set null,
    birth_date date not null
);

alter table cats_db.public.cats
    owner to catapi_user;

/*
    Cat friendship many-to-many table
*/
create table if not exists cats_db.public.cat_friendships
(
    cat1_id uuid not null
        references cats on delete cascade,
    cat2_id uuid not null
        references cats on delete cascade
);

alter table cats_db.public.cat_friendships
    owner to catapi_user;