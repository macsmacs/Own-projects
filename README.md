# Own projects

<h4>Call Center</h4>

<h6>Что уже сделано.</h6>
<p>Программа моделирует работу контактного центра. 10 операторов облуживают поступающие звонки трех категорий:
<ul><li>- технические вопросы;</li>
- финансовые вопросы;
- консультационные.
Приложение консольное и разработанно в Intellij IDEA.</ul></p>
<h6>Принцип работы программы.</h6>
<p>Звонки генерируются случайным образом и со случайными параметрами (номер телефона, категория звонка и длительность). Свободные операторы ожидают звонка в очереди и как только поступает звонок - первый оператор этого списка берет его на обработку. Как только обработка звонка оканчивается, оператор снова возвращаются в очередь ожиданий (в конец списка). Если свободных операторов нет, то формируется очередь звонков, тогда первый осободившийся оператор мгновенно берет на обработку первый звонок из этой очереди. Весь процесс отображается в консоли. Количество принятых звонков, сохраняется в файл, индивидуально, для каждого сотрудника.</p>
<h6>Структура программы.</h6>
<p>Приложение состоит из 6 классов. Операторы - объекты класса Operator. Звонки - объекты классов Tech, Finance и Potential, которые наследуются от абстрактного класса Call. В классе Call реализованны поля и методы, котырые используют его классы наследники, единственный метод toString() является абстрактным и реализован в классах наследниках. В классе Main используются 4 списка LinkedList, в качестве очереди операторов(свободных/занятых) и звонков (в очереди/в обработке). Также класс Main содержит методы обработки звонков, окончания звонков, сохранения статистики в файл и отображения в консоли процесса работы программы.</p>
<h6>Что будет сделано.</h6>
- Программа будет преобразованна в оконное приложение и распределена на нити, с учетом синхронизации для корректного выполнения.
- Кроме показателя количества принятых звонков, будет добавлен показатель средней длительности звонков, для каждого оператора индивидуально.
- Будет использованна технология SQL для сохранения статистики.
- Операторы будут создаваться динамически во время выполнения программы.
- Будет создано 3 отдела, каждый из которых компетентен только для определенной категории звонка.
