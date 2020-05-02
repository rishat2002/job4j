select count(company_id),c.name  from person p  join company c on
c.id=p.company_id group by company_id,c.name  order by count(company_id) desc
limit 1
(мне кажется это не совсем правильное решение)
пытался так
select max(count(company_id)),c.name  from person p  join company c on
c.id=p.company_id group by company_id,c.name
выдает ошибку ( вложенные вызовы агрегатных функций недопустимы)
select p.name,c.name from person p
join company c on
company_id=c.id and company_id!=5