# <div align=center >![csgo](https://user-images.githubusercontent.com/98232785/211071752-022e8252-99f5-479c-b8c4-d83a2def95e0.png)


# CS:GO Directory

CS:GO Directory - это мобильное приложение, в котором можно найти актуальные данные 
по киберспортивным команадам CS:GO.

В приложении доступны 9 команд, которые поделены по регионам (CIS,China,Europe)[^1]
У кждой команды свой дизайн экрана:

![image](https://user-images.githubusercontent.com/98232785/211076861-864f9fdc-d5c2-4441-8c42-7ec5233cb99c.png)
![image](https://user-images.githubusercontent.com/98232785/211077071-3b8517d7-0be0-41f6-ac19-a903a4bee9c4.png)
![image](https://user-images.githubusercontent.com/98232785/211077401-087a09ed-59f1-445d-bef6-438937dae07e.png)


Приложение построено на одном Activity, который заполняется в зависимости от выбора пользователя, с помощью [**Адаптера**](https://github.com/Alexandr-Stb/CS/blob/master/app/src/main/java/com/example/cs/MyAdapter.kt)

При клике происходит перестройка активити. Функции bind и transfer занимаются наполнением активити командами

```kotlin
fun bind(team: Team, context: Context) {
            titleItem.text = team.title
            image.setImageResource(team.logo)
            itemView.setOnClickListener {
                context.startActivity(this.transfer(team,context))
            }
}

private fun transfer(team: Team, context: Context): Intent{
            var i = Intent(context, TeamContent::class.java)
            i.putExtra(TeamContent.TEAM_EXTRA_KEY,team)
            return i
}
```

[^1]:[СНГ, Китай, Европа]
