# Generated by Django 2.2.2 on 2019-06-08 11:47

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('patients', '0002_patient_user'),
    ]

    operations = [
        migrations.AddField(
            model_name='patient',
            name='address',
            field=models.CharField(blank=True, max_length=250),
        ),
    ]
