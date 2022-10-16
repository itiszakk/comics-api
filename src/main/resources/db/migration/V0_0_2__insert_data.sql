SET search_path TO comics;

INSERT INTO character VALUES
    (DEFAULT,
     'Batman',
     'Bruce Wayne',
     'hero',
     'dc',
     'Bruce Wayne, who witnessed the murder of his billionaire parents as a child, swore to avenge their deaths. He trained extensively to achieve mental and physical perfection, mastering martial arts, detective skills, and criminal psychology. Costumed as a bat to prey on the fears of criminals, and utilizing a high-tech arsenal, he became the legendary Batman.',
     'https://images.hdqwalls.com/download/the-batman-knight-4k-tr-800x1280.jpg'),

    (DEFAULT,
     'Superman',
     'Kal-El',
     'hero',
     'dc',
     'Sent to Earth as an infant from the dying planet Krypton, Kal-El was adopted by the loving Kent family and raised in America''s heartland as Clark Kent. Using his immense solar-fueled powers, he became Superman to defend mankind against all manner of threats while championing truth, justice, and the American way!',
     'https://i.pinimg.com/736x/40/32/a0/4032a00a66733d809214a1ebad1ac66a.jpg'),

    (DEFAULT,
     'Wonder Woman',
     'Diana Prince',
     'hero',
     'dc',
     'The Amazon princess, blessed with god-like super abilities, Wonder Woman is one of Earth''s most powerful defenders of peace, justice, and equality and a member of the Justice League. She is considered an archetype for many heroines outside of comic book. Her initial origin depicted her as a clay baby brought to life by patron goddess Aphrodite, but in recent years she has been depicted as the daughter of Zeus and Amazon queen Hippolyta.',
     'https://i.pinimg.com/originals/11/2a/4a/112a4af63c97bff72f23b4da6a5c94ec.jpg'),

    (DEFAULT,
     'The Flash',
     'Barry Allen',
     'hero',
     'dc',
     'Having discovered his mother murdered and his father blamed for the act, forensic scientist Barry Allen sought to clear his father''s name and find the real killer. After being doused in chemicals and struck by lightning, Barry was granted the gift of super-speed. Now he protects his hometown of Central City as The Flash, the fastest man alive and founding member of the Justice League.',
     'https://i.pinimg.com/originals/39/09/e5/3909e5b08597fd7443464e59974268db.jpg'),

    (DEFAULT,
     'Aquaman',
     'Arthur Curry',
     'hero',
     'dc',
     'The son of an Atlantean queen and a lighthouse keeper from the town of Amnesty Bay, Arthur Curry would grow up to become the superhero Aquaman, and later take on his birthright as the King of Atlantis. He is a founding member of the Justice League and is among DC Comics'' most recognized heroes.',
     'https://i.pinimg.com/originals/26/04/fd/2604fd9c12390e5cfcee3373eb54c788.jpg'),

    (DEFAULT,
     'Green Lantern',
     'Hal Jordan',
     'hero',
     'dc',
     'With the ability to overcome great fear and harness the power of will, test-pilot Hal Jordan was chosen to be the Green Lantern of Sector 2814 inheriting the ring of the dying alien Green Lantern, Abin Sur. He later on went to creating his own power ring from his own will power. Through sheer will power and determination, Hal has established an impressive record of heroism across the galaxy with the help of his fellow Green Lanterns as well as his peers in the Justice League.',
     'https://i.pinimg.com/originals/d6/52/2e/d6522e15b0fbf3133e107e19c0f8795b.jpg'),

    (DEFAULT,
     'Cyborg',
     'Victor Stone',
     'hero',
     'dc',
     'Half man, half machine - all hero! After a near fatal incident, Victor Stone was cybernetically enhanced by his fat her. He now possesses the ability to communicate, manipulate, and interface with nearly all forms of technology. As he is constantly upgrading, he promises to defend the future from any threat. He is also a founding member of the Teen Titans, and eventually joined the Justice League.',
     'https://i.pinimg.com/originals/4a/55/e2/4a55e2855f4134b07216b4b2ca87b5a3.png'),

    (DEFAULT,
     'Nightwing',
     'Dick Grayson',
     'hero',
     'dc',
     'As the first Robin, Dick Grayson was the most famous sidekick in comic book history. As he ventured forth on his own, he formed the Teen Titans and became their leader. When the boy became a man, he became the independent hero known as Nightwing.',
     'https://i.pinimg.com/736x/23/8c/ba/238cba5a7b4ee6d7a7f017a096722834.jpg'),

    (DEFAULT,
     'Supergirl',
     'Kara Zor-El',
     'hero',
     'dc',
     'Kara Zor-El is Superman''s cousin and last survivor of Krypton''s Argo City. She has a brash and defiant personality that she developed in response to the destruction of Krypton. Currently, she''s operating out of National City alongside the D.E.O.',
     'https://i.pinimg.com/736x/46/ce/17/46ce171ebc3e6c8c0729a2720e75470b.jpg'),

    (DEFAULT,
     'The Joker',
     NULL,
     'villain',
     'dc',
     'The Joker, Clown Prince of Crime, is Batman''s arch-nemesis. An agent of chaos known for his malicious plots, wacky gadgets and insidious smile, he has caused Batman more suffering than any other villain he has ever faced. His origin, name, and true motivations remain a mystery.',
     'http://oyster.ignimgs.com/wordpress/stg.ign.com/2020/01/BATMAN093_CVR_color2.jpg'),

    (DEFAULT,
     'Harley Quinn',
     'Harleen Quinzel',
     'villain',
     'dc',
     'Harleen Quinzel was a psychiatric resident at Arkham Asylum, where she met the incarcerated Joker. Falling in love with her patient, she conspired to break him out of prison and eventually became his lover and loyal sidekick, Harley Quinn. She eventually left him to be her own woman, and has been and enemy and ally of Batman, and various other heroes.',
     'https://i.pinimg.com/736x/46/87/bc/4687bc86d53d4c6934b8e08e3aabe856--jason-fabok-dc-comic.jpg'),

    (DEFAULT,
     'General Zod',
     'Dru-Zod',
     'villain',
     'dc',
     'General Dru-Zod was a member of the Kryptonian military, exiled to the Phantom Zone by Jor-El after attempting to conquer Krypton. When he escaped years later he targeted Superman and his adopted planet Earth.',
     'https://moviecomicswhoswho.files.wordpress.com/2012/12/generalzodcomics2.jpg'),

    (DEFAULT,
     'Darkseid',
     'Uxas',
     'villain',
     'dc',
     'Uxas, famously known as Darkseid, is the supreme monarch of the ecumenopolis, Apokolips. Widely regarded as one of the Justice League''s worst adversaries, the greatest enemy of New Genesis and one of the biggest threats to the DC Multiverse, he seeks to bend everything to his will and remake the cosmos in his image, while searching for the Anti-Life Equation, an equation which seemingly consists of immense power that has the potential to dominate all life in the DC Multiverse.',
     'https://batman-news.com/wp-content/uploads/2014/12/World-End-10.jpg'),

    (DEFAULT,
     'Riddler',
     'Edward Nygma',
     'villain',
     'dc',
     'Edward Nygma is a villain obsessed with riddles, puzzles, and brain teasers, who took the alias of the Riddler to commit crimes. Riddler frequently tries to outsmart Gotham''s hero Batman, but is always defeated by the Dark Knight.',
     'https://static.wikia.nocookie.net/8169b64d-b6ab-4c99-b1db-0b3b75cfcf5d'),

    (DEFAULT,
     'Anti-Monitor',
     NULL,
     'villain',
     'dc',
     'The Anti-Monitor is the Monitor''s counterpart from the Anti-matter Universe. He is responsible for the original Crisis on Infinite Earths, was the sole Guardian of the Sinestro Corps and once, against his will, was the source of the Black Lantern Corps Central Power Battery.',
     'https://comicvine.gamespot.com/a/uploads/scale_small/10/100647/5462243-justice%20league%2047.jpg'),

    (DEFAULT,
     'Atrocitus',
     NULL,
     'villain',
     'dc',
     'One of the five survivors of the massacre in Sector 666 and founder of the Red Lantern Corps, Atrocitus anointed the Red Lantern in blood and harnessed the power of rage and red light.',
     'https://sun9-55.userapi.com/impg/fu_SKCLIOcVXQsajvscFaSHCjRpDQxiMKUuDnw/9McNN5KJzHc.jpg?size=453x604&quality=96&sign=f51474fc2f7ebcb7fbc73b6ffddf7e2f&type=album'),

    (DEFAULT,
     'Giganta',
     'Doris Zuel',
     'villain',
     'dc',
     'A villainous vixen with the power to grow into a towering, incredibly strong giantess. She often comes into conflict with Wonder Woman.',
     'https://comicvine.gamespot.com/a/uploads/scale_small/10/100647/6021015-giganta.jpg'),

    (DEFAULT,
     'Ares',
     NULL,
     'villain',
     'dc',
     'Ares is the Greek god of war. He is one of the Twelve Olympians, the son of Zeus and Hera. In Greek literature, he often represents the physical or violent and untamed aspect of war and is the personification of sheer brutality, in contrast to his sister, the armored Athena, whose functions as a goddess of intelligence include military strategy and generalship.',
     'https://i.pinimg.com/originals/05/ef/24/05ef24bfa8982fe5b1d4a7b9b02e4ec5.png'),

    (DEFAULT,
     'Black Manta',
     'David Hyde',
     'villain',
     'dc',
     'A notorious pirate and assassin, Black Manta is one of the most ruthless and feared super villains on Earth, and Aquaman''s mortal enemy.',
     'https://i.pinimg.com/originals/5c/e2/62/5ce26257b8a95c642138ce04a67209c1.jpg'),

    (DEFAULT,
     'Reversed-Flash',
     'Eobard Thawne',
     'villain',
     'dc',
     'Eobard Thawne was a brilliant scientist born in the 25th century, where Barry Allen''s heroism as the Flash is the stuff of legend. Seeking to emulate his idol, Thawne traveled back in time to meet the Flash, but learned instead that his destiny was to become the Reverse-Flash, Allen''s greatest nemesis. Rendered unstable by this knowledge, Thawne set out to erase Barry Allen from history and establish himself as the one true Flash.',
     'https://i.pinimg.com/originals/8e/56/07/8e560745a55ae6c2a7afa4ba03657801.jpg'),

    (DEFAULT,
     'Red Hood',
     'Jason Todd',
     'antihero',
     'dc',
     'Jason Todd was the second Robin, until he was brutally murdered by the Joker. After he was resurrected, Jason learned Batman didn''t avenge his death. Anguished and seeking vengeance, he initially turned against his mentor and took on the Clown Prince''s former identity: the Red Hood. He eventually returned to the Bat-Family and assembled a team of anti-heroes known as the Outlaws.',
     'https://comicvine.gamespot.com/a/uploads/scale_medium/12/124259/7219816-rco002_1579806821.jpg'),

    (DEFAULT,
     'Swamp Thing',
     'Alec Holland',
     'antihero',
     'dc',
     'Botanist Alec Holland became the avatar of the Green, known as the Swamp Thing, following his death in a swamp as a result of a horrific accident. With the ability to control any form of plant life, Swamp Thing uses his powers to protect both the human and the plant worlds.',
     'https://i.pinimg.com/originals/0f/84/6c/0f846c43024eed6bdaf2e45a4342e57f.jpg'),

    (DEFAULT,
     'Lobo',
     NULL,
     'antihero',
     'dc',
     'The last of the Czarnians, Lobo is known and feared across the universe as a bounty hunter who never misses his mark. Super-strong, immortal and unstoppable, the Main Man has frequently clashed with Superman, although they have on occasion found themselves on the same side.',
     'https://i.pinimg.com/736x/34/1a/6a/341a6a8699e1d7b7efe6ce2c8f545911.jpg'),

    (DEFAULT,
     'Catwoman',
     'Selina Kyle',
     'antihero',
     'dc',
     'Catwoman is a fictional character originating from DC Comics. Under the costumed alias of Catwoman, Selina Kyle, is a cat burglar with an on-again, off-again, romantic relationship with Batman. She is shown as a woman who is very strong-willed, independent and morally dubious.',
     'https://i.pinimg.com/736x/c9/ee/be/c9eebee76320769460540f6a06467b2b.jpg'),

    (DEFAULT,
     'John Constantine',
     NULL,
     'antihero',
     'dc',
     'John Constantine, the Hellblazer, is a working-class magician, occult detective and a golden-tongued con man. He is well-known for his scathing wit, endless cynicism, ruthless cunning and constant chain smoking. A roguish counterculture anti-hero, Constantine is also a strident humanist driven by a heartfelt desire to defend mankind from the forces of evil.',
     'https://i.pinimg.com/originals/4a/e6/3d/4ae63d3e740bee5a4f491fcc27346c46.jpg'),

    (DEFAULT,
     'Spider-Man',
     'Peter Parker',
     'hero',
     'marvel',
     'Peter Parker was bitten by a radioactive spider as a teenager, granting him spider-like powers. After the death of his Uncle Ben, Peter learned that "with great power, comes great responsibility." Swearing to always protect the innocent from harm, Peter Parker became Spider-Man.',
     'https://i.pinimg.com/originals/04/d1/fe/04d1fe4857cca095fc89124f95b5dc53.jpg'),

    (DEFAULT,
     'Wolverine',
     'James Howlett',
     'hero',
     'marvel',
     'A long-lived mutant with the rage of a beast and the soul of a Samurai, James "Logan" Howlett''s once mysterious past is filled with blood, war, and betrayal. Possessing an accelerated healing factor, keenly enhanced senses, and bone claws in each hand (along with his skeleton) that are coated in adamantium; Wolverine is, without question, the ultimate weapon.',
     'https://i.pinimg.com/736x/2f/37/3c/2f373c17d34f05728cb16ead919d17ff.jpg'),

    (DEFAULT,
     'Captain America',
     'Steve Rogers',
     'hero',
     'marvel',
     'During World War II, Steve Rogers volunteered to receive the experimental Super-Soldier Serum. Enhanced to the pinnacle of human physical potential and armed with an unbreakable shield, he became Captain America. After a failed mission left him encased in ice for decades, he was found and revived by the Avengers, later joining their ranks and eventually becoming the team''s leader.',
     'https://comicvine.gamespot.com/a/uploads/scale_super/11112/111121684/4540131-9098821103-44862.jpg'),

    (DEFAULT,
     'Iron Man',
     'Tony Stark',
     'hero',
     'marvel',
     'Tony Stark was the arrogant son of wealthy, weapon manufacturer Howard Stark. Tony cared only about himself, but he would have a change of heart after he was kidnapped by terrorists and gravely injured. Pressured to create a weapon of mass destruction, Stark instead created a suit of armor powerful enough for him to escape. Tony used his vast resources and intellect to make the world a better place as The Invincible Iron Man. Stark''s super hero identity led him to become a founding member of the Avengers.',
     'https://i.pinimg.com/originals/ba/c2/ae/bac2aee8e09f7b564f9ef0d4311eae72.jpg'),

    (DEFAULT,
     'Thor',
     'Thor Odinson',
     'hero',
     'marvel',
     'Thor Odinson is the All-father of Asgard /God of Thunder, offspring of All-Father Odin & Elder-Goddess Gaea. Combining the powers of both realms makes him an elder-god hybrid and a being of no perceivable limits. Armed with his enchanted Uru hammer Mjolnir which helps him to channel his godly energies. The mightiest and the most beloved warrior in all of Asgard, a staunch ally for good and one of the most powerful beings in the multiverse/omniverse. Thor is also a founding member of the Avengers.',
     'https://i.pinimg.com/originals/5b/4f/b0/5b4fb0fd1adfec0130e679a092a050fa.jpg'),

    (DEFAULT,
     'Hulk',
     'Bruce Banner',
     'hero',
     'marvel',
     'After being bombarded with a massive dose of gamma radiation while saving a young man''s life during an experimental bomb testing, Dr. Robert Bruce Banner was transformed into the Incredible Hulk: a green behemoth who is the living personification of rage and pure physical strength.',
     'https://upload.wikimedia.org/wikipedia/ru/c/cc/Hulk_Marvel.jpg'),

    (DEFAULT,
     'Doctor Strange',
     'Stephen Strange',
     'hero',
     'marvel',
     'Dr. Stephen Strange was once a gifted but egotistical surgeon who sought out the Ancient One to heal his hands after they were wounded in a car accident. Instead, the Ancient One trained him to become Master of the Mystic Arts and the Sorcerer Supreme of Earth.',
     'https://i.pinimg.com/originals/17/13/fb/1713fb93bd2d533c0d3caf021da44098.jpg'),

    (DEFAULT,
     'Daredevil',
     'Matthew Murdock',
     'antihero',
     'marvel',
     'As a child, Matt Murdock was blinded by radioactive waste while trying to save an elderly stranger about to get hit by a truck carrying the dangerous material. In turn, his other senses were heightened to superhuman sharpness and he gained a form of "radar sense". By day, he is a successful trial lawyer; but by night, he guards Hell''s Kitchen as Daredevil: the Man Without Fear.',
     'https://snappi-wpengine.netdna-ssl.com/wp-content/uploads/2020/02/EQHuvobWAAA9c52-1011x1536.jpg'),

    (DEFAULT,
     'Doctor Doom',
     'Victor Von Doom ',
     'villain',
     'marvel',
     'The very mention of his name makes lesser men tremble! The brilliant scientist whose iron mask conceals his scarred (but once handsome) face! Master of science and sorcery, Victor Von Doom is the monarch of Latveria, attempting the betterment of humanity through world conquest! Unequaled and unrivaled in every manner, Doctor Doom has had many conflicts with both earthly and cosmic super-beings, but he will always be known as the eternal nemesis of Reed Richards and his accursed Fantastic Four!',
     'https://i.pinimg.com/originals/46/42/e6/4642e662e0f88f3e6987c30ecd37fbfc.jpg'),

    (DEFAULT,
     'Deadpool',
     'Wade Wilson',
     'antihero',
     'marvel',
     'Wade Wilson is a former test subject of the Weapon X program, where he received his regenerative healing factor through the scientific experiments conducted upon him. A prominent enemy, ally and later, member of X-Force. He''s famous for breaking the Fourth Wall.',
     'https://i.pinimg.com/736x/49/89/f7/4989f738183de2c50ac2ffda6a02a354.jpg'),

    (DEFAULT,
     'The Punisher',
     'Frank Castle',
     'antihero',
     'marvel',
     'When U.S. Marine veteran Frank Castle''s family''s was murdered for witnessing a mob hit, the man vowed to avenge their deaths and became a one-man army in his personal war against the criminal underworld. With a distinct death''s head skull adorning his chest, Frank Castle became the vigilante known as the Punisher.',
     'https://i.pinimg.com/736x/81/30/ff/8130ffd2311b363f5880a49bee9d5dcd--the-punisher-educational-illustrations.jpg'),

    (DEFAULT,
     'Kingpin',
     'Wilson Fisk',
     'villain',
     'marvel',
     'The Kingpin is a supervillain originating from Marvel Comics. The self-proclaimed kingpin of crime, Wilson Fisk is one of the most prominent figures of organized crime in the United States. He is the king of mobsters, controlling organized crime on the East Coast with an iron fist. Kingpin is a major enemy of superheroes Spider-Man and Daredevil.',
     'https://static.displate.com/857x1200/displate/2018-06-28/3125ebf88d480536b6de175f7819ac37_b2c1dae70251e859d2d37ecaaa6d20c1.jpg'),

    (DEFAULT,
     'Galactus',
     'Galan',
     'villain',
     'marvel',
     'Galactus is the infamous "Devourer of Worlds" in the Marvel Universe. His powers are nearly omnipotent. He has appointed several entities as his Heralds, imbuing them with the Power Cosmic. He uses energy from the core of planets and universal sources to sustain himself. He has currently been changed into the Lifebringer, who restores life to the worlds Galactus has destroyed.',
     'https://i.pinimg.com/originals/76/45/2d/76452d57a2cad15d45a2a860ac3ba964.jpg'),

    (DEFAULT,
     'Red Skull',
     'Johann Schmidt',
     'villain',
     'marvel',
     'A long-time archenemy of Captain America, Johann Schmidt is a proud Nazi general and the embodiment of evil, fear, and horror. He is known as the ruthless Red Skull.',
     'https://i.pinimg.com/originals/a7/f7/53/a7f753395d54c85c8b30e219b52f89b8.jpg'),

    (DEFAULT,
     'Ghost Rider',
     'Jonathan Blaze ',
     'antihero',
     'marvel',
     'Johnny Blaze, a motorcycle stuntman, became bound to the Spirit of Vengeance known as Zarathos after making a deal with Mephisto to spare the life of his surrogate father. With the power to control hellfire and to inflict pain on those he deems evil with his Penance Stare, Johnny seeks vengeance as Ghost Rider.',
     'https://img2.reactor.cc/pics/post/full/Marvel-%D1%84%D1%8D%D0%BD%D0%B4%D0%BE%D0%BC%D1%8B-Ghost-Rider-1988966.jpeg'),

    (DEFAULT,
     'Thanos',
     'Dione',
     'villain',
     'marvel',
     'An Eternal with the Deviant gene, making him unique and extremely powerful, even amongst his own kind. Above all else, Thanos loves and worships Mistress Death. Few can equal his intelligence, strength, and ambition for power. Thanos has wielded the Cosmic Cube, the Infinity Gauntlet, and even the Heart of the Universe.',
     'https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/4aa79222604309.56315705902ee.jpg'),

    (DEFAULT,
     'Mephisto',
     NULL,
     'villain',
     'marvel',
     'A sadistic, cruel, and dangerous extra-dimensional demon with unknown origins, Mephisto is incredibly powerful. Based on Mephistopheles, a demon from the Faust legend, Mephisto is known for stealing souls and torturing them in his hell-like dimension. He is one of the many Hell-Lords in the Marvel Universe.',
     'https://cdnb.artstation.com/p/assets/images/images/028/814/745/medium/jose-real-mephisto.jpg?1595592242'),

    (DEFAULT,
     'Ultron',
     NULL,
     'villain',
     'marvel',
     'Created by Henry Pym to be a technological landmark, Ultron soon intellectually surpassed his "father" and eventually fought the Avengers after organizing the Masters of Evil. He has clashed with the Avengers numerous times, driven by his hatred of all organic life and his desire to witness its total destruction.',
     'https://i.pinimg.com/736x/91/b7/5f/91b75fa25312cf156daf487fe09444d3--avengers-marvel-marvel-comics.jpg'),

    (DEFAULT,
     'Kang',
     'Nathaniel Richards',
     'villain',
     'marvel',
     'A time-traveling conqueror with vast powers and technological supremacy, Kang the Conqueror has taken every opportunity to torment the Marvel Universe, and is one of the Avengers'' greatest foes. Kang has amassed an empire with a citizenry of millions, and cut a swath of terror through the ages.',
     'https://browsecat.net/sites/default/files/kang-the-conqueror-marvel-comic-wallpapers-56435-933387-5439360.png'),

    (DEFAULT,
     'Storm',
     'Ororo Munroe',
     'hero',
     'marvel',
     'Born an omega level mutant with ability to manipulate the energies of the natural world to generate weather phenomena be it empty space, planetary atmospheres and even within living beings, Ororo Munroe is one of the most powerful mutants on the X-men''s roster and in the Marvel Universe.',
     'https://images.squarespace-cdn.com/content/v1/5edb18356cb927448d88a93f/1607293095228-35E5MVI3FBX9ZGLCPII2/Storm_1.jpg'),

    (DEFAULT,
     'Professor X',
     'Charles Xavier',
     'hero',
     'marvel',
     'Professor Charles Xavier is the creator of the X-Men and founder of the Xavier School for Gifted Youngsters. His dream of peaceful coexistence between mutants and humanity has long been the driving force for the X-Men. An immensely powerful telepath and scientific genius, Xavier was among the world''s greatest masterminds. Killed at the hands of a Phoenix crazed Cyclops, Xavier''s memory and dream still remains and motivates his X-Men to keep fighting for a world that fears and hates them.',
     'https://comicvine.gamespot.com/a/uploads/scale_medium/10/100647/7261595-hox1pichelli.jpg'),

    (DEFAULT,
     'Magneto',
     'Erik Lehnsherr',
     'villain',
     'marvel',
     'Among the most powerful, recognizable, and infamous mutants to inhabit the planet Earth, Magneto was the X-Men''s first major nemesis. Now known as a revolutionist and terrorist, Magneto has fought for the X-Men as many times as he’s been against them.',
     'https://i.pinimg.com/736x/c4/0a/a1/c40aa1646e05d8cd97e299d767be00a7.jpg');



