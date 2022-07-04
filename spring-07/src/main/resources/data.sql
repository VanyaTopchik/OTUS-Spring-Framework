insert into authors (name) values ('Достоевский');
insert into authors (name) values ('Булгаков');
insert into authors (name) values ('Пушкин');
insert into authors (name) values ('Толстой');
insert into authors (name) values ('Гоголь');
insert into genres (genre) values ('Роман');
insert into genres (genre) values ('Повесть');
insert into genres (genre) values ('Поэма');
insert into genres (genre) values ('Комедия');
insert into books (title, author_id, genre_id, description) values ('Преступление и наказание', 1, 1, '«Преступление и наказание» (1866) — роман об одном преступлении. Двойное убийство, совершенное бедным студентом из-за денег. Трудно найти фабулу проще, но интеллектуальное и душевное потрясение, которое производит роман, — неизгладимо. В чем здесь загадка? Кроме простого и очевидного ответа — «в гениальности Достоевского» — возможно, существует как минимум еще один: «проклятые» вопросы не имеют простых и положительных ответов. Нищета, собственные страдания и страдания близких всегда ставили и будут ставить человека перед выбором: имею ли я право преступить любой нравственный закон, чтобы потом стать спасителем униженных и утешителем слабых; должен ли я сперва возлюбить себя, а только потом, став сильным, возлюбить ближнего своего? Это вечные вопросы.');
insert into books (title, author_id, genre_id, description) values ('Братья Карамазовы', 1, 1, 'Самый сложный, самый многоуровневый и неоднозначный из романов Достоевского, который критики считали то «интеллектуальным детективом», то «ранним постмодернизмом», то — «лучшим из произведений о загадочной русской душе». Роман, легший в основу десятков экранизаций — от предельно точных до самых отвлеченных, — но не утративший своей духовной силы…');
insert into books (title, author_id, genre_id, description) values ('Мастер и Маргарита', 2, 1, '"Мастер и Маргарита" - итоговое произведение выдающегося отечественного прозаика и драматурга Михаила Афанасьевича Булгакова. Обещание, содержащееся на страницах книги - "ваш роман вам принесет еще сюрпризы", - оправдалось вполне: написанный Мастером провидческий роман о дьяволе, пожалуй, явился одной из самых загадочных, удивительных и самых читаемых книг XX столетия! Многие слова и выражения из этого произведения вошли в современный лексикон, а персонажи своею реальностью затмили действительно существующих граждан.');
insert into books (title, author_id, genre_id, description) values ('Собачье сердце', 2, 2, '«Собачье сердце» – одно из самых любимых читателями произведений Михаила Булгакова. Вас ждёт полный рассказ о необыкновенном эксперименте гениального доктора.');
insert into books (title, author_id, genre_id, description) values ('Евгений Онегин', 3, 1, 'Роман в стихах «Евгений Онегин» стал центральным событием в литературной жизни пушкинской поры. И с тех пор шедевр А.С.Пушкина не утратил своей популярности, по-прежнему любим и почитаем миллионами читателей.');
insert into books (title, author_id, genre_id, description) values ('Капитанская дочка', 3, 1, 'В романе «Капитанская дочка» А.С.Пушкин нарисовал яркую картину стихийного крестьянского восстания под предводительством Емельяна Пугачева. Произведение включено в школьную программу и рекомендовано для внеклассного чтения. Для детей среднего и старшего школьного возраста.');
insert into books (title, author_id, genre_id, description) values ('Война и мир', 4, 1, 'Роман-эпопея, описывающий события войн против Наполеона: 1805 года и отечественной 1812 года. Признан критикой всего мира величайшим эпическим произведением литературы нового времени.');
insert into books (title, author_id, genre_id, description) values ('Анна Каренина', 4, 1, '«Анна Каренина», один из самых знаменитых романов Льва Толстого, начинается ставшей афоризмом фразой: «Все счастливые семьи похожи друг на друга, каждая несчастливая семья несчастлива по-своему». Это книга о вечных ценностях: о любви, о вере, о семье, о человеческом достоинстве.');
insert into books (title, author_id, genre_id, description) values ('Мертвые души', 5, 3, '«…Говоря о „Мертвых душах“, можно вдоволь наговориться о России», – это суждение поэта и критика П. А. Вяземского объясняет особое место поэмы Гоголя в истории русской литературы: и огромный успех у читателей, и необычайную остроту полемики вокруг главной гоголевской книги, и многообразие высказанных мнений, каждое из которых так или иначе вовлекает в размышления о природе национального мышления и культурного сознания, о настоящем и будущем России.');
insert into books (title, author_id, genre_id, description) values ('Ревизор', 5, 4, '«Ревизор» — одна из лучших русских комедий. Н.В. Гоголь заставил современников смеяться над тем, к чему они привыкли и что перестали замечать. И сегодня комедия, созданная великим русским писателем, продолжая звучать современно, указывает путь к нравственному возрождению.');
insert into comments (book_id, comment) values (1, 'На один раз сойдет');
insert into comments (book_id, comment) values (2, 'Не понравилось');
insert into comments (book_id, comment) values (3, 'Отличная книга');