Primeira aula Resolvendo um quiz do site [SQL Murder Mystery ](https://mystery.knightlab.com/)
```
SELECT * FROM crime_scene_report
WHERE date = "20180115" and type = "murder" and city = "SQL City"

SELECT * FROM person
WHERE address_street_name = "Northwestern Dr" order by address_number DESC

SELECT *
FROM person
WHERE name like '%Annabel%' AND address_street_name = "Franklin Ave";

SELECT *
FROM interview
WHERE person_id = 14887 OR person_id = 16371;

SELECT *
FROM get_fit_now_check_in 
WHERE membership_id like "%48Z%" AND check_in_date = 20180109 
order by check_in_date;

SELECT *
FROM drivers_license
WHERE plate_number like "%H42W%";

SELECT *
FROM person
WHERE license_id = "423327" OR license_id = "664760";

SELECT *
FROM get_fit_now_member
WHERE person_id = "51739" OR person_id = "67318";

SELECT *
FROM interview
WHERE person_id = 67318;

SELECT *
FROM drivers_license
WHERE car_make = "Tesla" AND car_model = "Model S" AND 
gender = "female" AND hair_color = "red";

SELECT *
FROM person
WHERE license_id = "202298" OR license_id = "291182" OR license_id = "918773";

SELECT person_id, count(*), event_name
FROM facebook_event_checkin 
GROUP BY person_id
having count(*) = 3 AND event_name = "SQL Symphony Concert" AND date like "%201712%";

```
