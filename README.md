## ProjetoBeca

Um APP criado para botar em prática conhecimentos adquiridos na Beca de Mobile da everis. É um APP simples para listar foto, nome e descrição dos personagens Marvel baseado na API oficial da criadora.

# Dependências:
[Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java
[Moshi](https://github.com/square/moshi/) - Moshi is a modern JSON library for Android and Java. It makes it easy to parse JSON into Java objects
[Recycler View](https://developer.android.com/guide/topics/ui/layout/recyclerview) - Create a List with RecyclerView
[Glide](https://github.com/bumptech/glide) - Glide is a fast and efficient open source media management and image loading framework for Android that wraps media decoding, memory and disk caching, and resource pooling into a simple and easy to use interface.

# Passos para execução
1- Instale o Android Studio.
2- clone o repositório.
3- Substitua as constantes do arquivo Constants.kt para as suas Chaves de API(Public e Private):
```
const val PUBLIC_KEY = "YOUR PUBLIC KEY HERE"
const val PRIVATE_KEY = "YOUR PRIVATE KEY HERE"
val TS = (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()
val HASH = "$TS$PRIVATE_KEY$PUBLIC_KEY"
```
4- Baixe as dependências, SDK e Java que ao compilar automaticamente o Android Studio popula a gradle.
