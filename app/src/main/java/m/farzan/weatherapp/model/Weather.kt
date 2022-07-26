package m.farzan.weatherapp.model

data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)

/*

cod	"200"
message	0
cnt	40
list
0	{…}
1	{…}
2	{…}
3	{…}
4
dt	1658350800
main
temp	30.19
feels_like	28.28
temp_min	30.19
temp_max	30.19
pressure	1002
sea_level	1002
grnd_level	893
humidity	12
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01n"
clouds
all	0
wind
speed	1.48
deg	291
gust	2.13
visibility	10000
pop	0
sys
pod	"n"
dt_txt	"2022-07-20 21:00:00"
5
dt	1658361600
main
temp	28.26
feels_like	26.82
temp_min	28.26
temp_max	28.26
pressure	1003
sea_level	1003
grnd_level	892
humidity	14
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01n"
clouds
all	0
wind
speed	3.21
deg	344
gust	3.77
visibility	10000
pop	0
sys
pod	"n"
dt_txt	"2022-07-21 00:00:00"
6
dt	1658372400
main
temp	29.39
feels_like	27.71
temp_min	29.39
temp_max	29.39
pressure	1004
sea_level	1004
grnd_level	894
humidity	18
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	0
wind
speed	2.38
deg	307
gust	3.16
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-21 03:00:00"
7
dt	1658383200
main
temp	34.34
feels_like	31.83
temp_min	34.34
temp_max	34.34
pressure	1004
sea_level	1004
grnd_level	895
humidity	13
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	0
wind
speed	2.06
deg	354
gust	2.23
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-21 06:00:00"
8
dt	1658394000
main
temp	38.03
feels_like	34.92
temp_min	38.03
temp_max	38.03
pressure	1001
sea_level	1001
grnd_level	895
humidity	8
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	0
wind
speed	2.52
deg	8
gust	2.95
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-21 09:00:00"
9
dt	1658404800
main
temp	39.41
feels_like	36.03
temp_min	39.41
temp_max	39.41
pressure	999
sea_level	999
grnd_level	893
humidity	7
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	0
wind
speed	2.68
deg	1
gust	2.91
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-21 12:00:00"
10
dt	1658415600
main
temp	38
feels_like	34.9
temp_min	38
temp_max	38
pressure	999
sea_level	999
grnd_level	893
humidity	8
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	0
wind
speed	2.49
deg	41
gust	3.28
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-21 15:00:00"
11
dt	1658426400
main
temp	33.83
feels_like	31.34
temp_min	33.83
temp_max	33.83
pressure	1001
sea_level	1001
grnd_level	893
humidity	12
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01n"
clouds
all	0
wind
speed	1.49
deg	101
gust	1.69
visibility	10000
pop	0
sys
pod	"n"
dt_txt	"2022-07-21 18:00:00"
12
dt	1658437200
main
temp	31.76
feels_like	29.56
temp_min	31.76
temp_max	31.76
pressure	1001
sea_level	1001
grnd_level	892
humidity	13
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01n"
clouds
all	0
wind
speed	2.06
deg	141
gust	2.24
visibility	10000
pop	0
sys
pod	"n"
dt_txt	"2022-07-21 21:00:00"
13
dt	1658448000
main
temp	29.26
feels_like	27.57
temp_min	29.26
temp_max	29.26
pressure	1001
sea_level	1001
grnd_level	891
humidity	15
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01n"
clouds
all	0
wind
speed	0.95
deg	101
gust	1.3
visibility	10000
pop	0
sys
pod	"n"
dt_txt	"2022-07-22 00:00:00"
14
dt	1658458800
main
temp	30.92
feels_like	28.87
temp_min	30.92
temp_max	30.92
pressure	1003
sea_level	1003
grnd_level	894
humidity	14
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	0
wind
speed	1.43
deg	328
gust	1.56
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-22 03:00:00"
15
dt	1658469600
main
temp	35.97
feels_like	33.2
temp_min	35.97
temp_max	35.97
pressure	1003
sea_level	1003
grnd_level	895
humidity	10
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	0
wind
speed	0.85
deg	21
gust	1.2
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-22 06:00:00"
16
dt	1658480400
main
temp	40.55
feels_like	37.18
temp_min	40.55
temp_max	40.55
pressure	1000
sea_level	1000
grnd_level	895
humidity	8
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	0
wind
speed	4.1
deg	9
gust	4.92
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-22 09:00:00"
17
dt	1658491200
main
temp	41.56
feels_like	37.9
temp_min	41.56
temp_max	41.56
pressure	998
sea_level	998
grnd_level	893
humidity	7
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	0
wind
speed	4.92
deg	31
gust	5.44
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-22 12:00:00"
18
dt	1658502000
main
temp	39.67
feels_like	36.26
temp_min	39.67
temp_max	39.67
pressure	998
sea_level	998
grnd_level	892
humidity	7
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	0
wind
speed	4.26
deg	67
gust	5.57
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-22 15:00:00"
19
dt	1658512800
main
temp	35.09
feels_like	32.37
temp_min	35.09
temp_max	35.09
pressure	1000
sea_level	1000
grnd_level	893
humidity	7
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01n"
clouds
all	0
wind
speed	2.86
deg	97
gust	2.97
visibility	10000
pop	0
sys
pod	"n"
dt_txt	"2022-07-22 18:00:00"
20
dt	1658523600
main
temp	32.24
feels_like	29.98
temp_min	32.24
temp_max	32.24
pressure	1000
sea_level	1000
grnd_level	891
humidity	9
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01n"
clouds
all	0
wind
speed	1.13
deg	156
gust	1.48
visibility	10000
pop	0
sys
pod	"n"
dt_txt	"2022-07-22 21:00:00"
21
dt	1658534400
main
temp	30.16
feels_like	28.26
temp_min	30.16
temp_max	30.16
pressure	1000
sea_level	1000
grnd_level	890
humidity	11
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01n"
clouds
all	0
wind
speed	1.04
deg	129
gust	1.32
visibility	10000
pop	0
sys
pod	"n"
dt_txt	"2022-07-23 00:00:00"
22
dt	1658545200
main
temp	31.88
feels_like	29.67
temp_min	31.88
temp_max	31.88
pressure	1001
sea_level	1001
grnd_level	893
humidity	10
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	0
wind
speed	1.81
deg	326
gust	1.92
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-23 03:00:00"
23
dt	1658556000
main
temp	37.08
feels_like	34.05
temp_min	37.08
temp_max	37.08
pressure	1001
sea_level	1001
grnd_level	894
humidity	7
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	0
wind
speed	1.63
deg	1
gust	1.62
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-23 06:00:00"
24
dt	1658566800
main
temp	41.35
feels_like	37.38
temp_min	41.35
temp_max	41.35
pressure	998
sea_level	998
grnd_level	893
humidity	5
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	0
wind
speed	3.03
deg	2
gust	3.36
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-23 09:00:00"
25
dt	1658577600
main
temp	42.81
feels_like	38.53
temp_min	42.81
temp_max	42.81
pressure	996
sea_level	996
grnd_level	891
humidity	5
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	0
wind
speed	5.95
deg	21
gust	4.6
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-23 12:00:00"
26
dt	1658588400
main
temp	40.34
feels_like	36.7
temp_min	40.34
temp_max	40.34
pressure	995
sea_level	995
grnd_level	890
humidity	6
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	0
wind
speed	5.49
deg	25
gust	7.86
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-23 15:00:00"
27
dt	1658599200
main
temp	35.34
feels_like	32.61
temp_min	35.34
temp_max	35.34
pressure	997
sea_level	997
grnd_level	890
humidity	9
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01n"
clouds
all	0
wind
speed	2.55
deg	133
gust	3.25
visibility	10000
pop	0
sys
pod	"n"
dt_txt	"2022-07-23 18:00:00"
28
dt	1658610000
main
temp	32.97
feels_like	30.58
temp_min	32.97
temp_max	32.97
pressure	997
sea_level	997
grnd_level	889
humidity	10
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01n"
clouds
all	0
wind
speed	2.25
deg	158
gust	2.41
visibility	10000
pop	0
sys
pod	"n"
dt_txt	"2022-07-23 21:00:00"
29
dt	1658620800
main
temp	30.63
feels_like	28.63
temp_min	30.63
temp_max	30.63
pressure	997
sea_level	997
grnd_level	888
humidity	12
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01n"
clouds
all	1
wind
speed	0.86
deg	147
gust	1.66
visibility	10000
pop	0
sys
pod	"n"
dt_txt	"2022-07-24 00:00:00"
30
dt	1658631600
main
temp	31.8
feels_like	29.59
temp_min	31.8
temp_max	31.8
pressure	999
sea_level	999
grnd_level	890
humidity	11
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	6
wind
speed	2.01
deg	322
gust	2.2
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-24 03:00:00"
31
dt	1658642400
main
temp	37.27
feels_like	34.26
temp_min	37.27
temp_max	37.27
pressure	998
sea_level	998
grnd_level	891
humidity	8
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	4
wind
speed	0.75
deg	36
gust	1.26
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-24 06:00:00"
32
dt	1658653200
main
temp	41.74
feels_like	37.86
temp_min	41.74
temp_max	41.74
pressure	995
sea_level	995
grnd_level	890
humidity	6
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	1
wind
speed	1.7
deg	36
gust	2.21
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-24 09:00:00"
33
dt	1658664000
main
temp	43.67
feels_like	39.47
temp_min	43.67
temp_max	43.67
pressure	992
sea_level	992
grnd_level	888
humidity	6
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	0
wind
speed	3.17
deg	46
gust	2.85
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-24 12:00:00"
34
dt	1658674800
main
temp	41.5
feels_like	38.04
temp_min	41.5
temp_max	41.5
pressure	991
sea_level	991
grnd_level	887
humidity	8
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	0
wind
speed	4.7
deg	68
gust	6.71
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-24 15:00:00"
35
dt	1658685600
main
temp	36.54
feels_like	33.86
temp_min	36.54
temp_max	36.54
pressure	993
sea_level	993
grnd_level	887
humidity	12
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01n"
clouds
all	0
wind
speed	3.62
deg	148
gust	5.51
visibility	10000
pop	0
sys
pod	"n"
dt_txt	"2022-07-24 18:00:00"
36
dt	1658696400
main
temp	33.99
feels_like	31.55
temp_min	33.99
temp_max	33.99
pressure	994
sea_level	994
grnd_level	886
humidity	14
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01n"
clouds
all	1
wind
speed	4.02
deg	166
gust	6
visibility	10000
pop	0
sys
pod	"n"
dt_txt	"2022-07-24 21:00:00"
37
dt	1658707200
main
temp	31.5
feels_like	29.38
temp_min	31.5
temp_max	31.5
pressure	994
sea_level	994
grnd_level	886
humidity	16
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01n"
clouds
all	3
wind
speed	2.03
deg	100
gust	2.52
visibility	10000
pop	0
sys
pod	"n"
dt_txt	"2022-07-25 00:00:00"
38
dt	1658718000
main
temp	32.41
feels_like	30.18
temp_min	32.41
temp_max	32.41
pressure	996
sea_level	996
grnd_level	888
humidity	16
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	0
wind
speed	1.76
deg	349
gust	1.9
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-25 03:00:00"
39
dt	1658728800
main
temp	36.7
feels_like	34.2
temp_min	36.7
temp_max	36.7
pressure	997
sea_level	997
grnd_level	890
humidity	14
temp_kf	0
weather
0
id	800
main	"Clear"
description	"clear sky"
icon	"01d"
clouds
all	0
wind
speed	6.07
deg	330
gust	5.01
visibility	10000
pop	0
sys
pod	"d"
dt_txt	"2022-07-25 06:00:00"
city
id	143073
name	"Ardakān"
coord
lat	32.31
lon	54.0175
country	"IR"
population	58834
timezone	16200
sunrise	1658280626
sunset	1658330983
 */